package org.jlf.soa.mvc.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.cache.JLFCacheClient;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.soa.mvc.container.ann.JLFMVCBean;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;

/**
 * 
 * @ClassName: JLFMVCDao
 * @Description:JAFMVCDao基础类
 * @author Lone Wolf
 * @date 2019年5月27日
 * @param <ENTITY>
 */
@JLFMVCBean(generate = JLFMVCDaoGenerate.class)
public abstract class JLFMVCDao<ENTITY extends JLFMVCEntity> {

	public static final String tableNameSeparator = "___";

	protected String fieldStr = null; // bean字段的字符串集合,便于getById和Insert操作
	private List<Field> fieldList = null; // bean字段的list类型,便于update操作
	private Map<String, Class<?>> fieldNameEnumClsMapping = null; // 字段与枚举类型的映射
	private Map<String, Method> fieldSetMapping = null; // bean字段和set方法的映射
	private Map<String, Method> fieldGetMapping = null; // bean字段和get方法的映射
	private Class<ENTITY> entityCls = null; // 当前bean的class
	protected String tableName = null; // 当前bean对应的数据库表名
	protected boolean isCache = false;// 当前bean是否需要缓存
	protected int seconds = -1;// 缓存有效期
	protected String cacheKeyFormat = null;// 缓存的key值
	protected String cacheReadIdLockKeyFormat = null;// 缓存id的读锁key值
	protected String cacheWriteIdLockKeyFormat = null;// 缓存id的读锁key值

	private String getByIdSql = null;
	private String getByIdWithTableNameSql = null;
	private String deleteSql = null;
	private String deleteWithTableNameSql = null;

	/**
	 * 
	 * @Title: init
	 * @Description:初始化dao相关变量
	 */
	public void init() {
		initBeanCls();
		initFields();
		initTableName();
		initFieldMapping();
		initSqls();
	}

	/**
	 * 
	 * @Title: getConn
	 * @Description:获取当前线程连接
	 * @return
	 */
	public Connection getConn() {
		String dbName = getDbName();
		return JLFDbPoolClient.get().getConn(dbName);

	}

	/**
	 * 
	 * @Title: getConn
	 * @Description:获取当前线程连接
	 * @return
	 */
	public Connection getConn(String dbName) {
		return JLFDbPoolClient.get().getConn(dbName);

	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:获取当前的dbName
	 * @return
	 */
	public String getDbName() {
		String dbName = null;
		JLFMVCBeanTableMapped mapped = this.entityCls.getAnnotation(JLFMVCBeanTableMapped.class);
		if (mapped == null) {
			dbName = JLFDbPool.mainDbName;
		} else if ("?".equals(mapped.dbName())) {
			dbName = JLFMVCThreadLocal.getDbName();
		} else if (mapped.dbName() == null || mapped.dbName().equals("")) {
			dbName = JLFDbPool.mainDbName;
		} else {
			dbName = mapped.dbName();
		}
		return dbName;
	}

	/**
	 * 
	 * @Title: initBeanCls
	 * @Description:获取当前bean的class类型
	 * @return
	 */
	private void initBeanCls() {
		this.entityCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		JLFMVCDaoMapping.addEntityDaoMapping(entityCls, this);
	}

	/**
	 * 
	 * @Title: getFieldStr
	 * @Description: 获取bean字段的字符串集合
	 * @return
	 */
	private void initFields() {
		this.fieldList = new ArrayList<Field>();
		List<Field> allFields = ReflectUtil.getAllFields(this.entityCls);
		StringBuffer fieldsSb = new StringBuffer();
		for (Field field : allFields) {
			String fieldName = field.getName();
			if (fieldName.equals("serialVersionUID")) {
				continue;
			}
			JLFMVCBeanFieldMapped mapped = field.getAnnotation(JLFMVCBeanFieldMapped.class);
			if (mapped != null && mapped.isSkipMapped()) {
				continue;
			}
			this.fieldList.add(field);
			fieldsSb.append(fieldName).append(",");
		}
		this.fieldStr = fieldsSb.substring(0, fieldsSb.length() - 1);
	}

	/**
	 * 
	 * @Title: getTableName
	 * @Description:获取当前bean对应的数据库表名,缓存信息
	 * @return
	 */
	private void initTableName() {
		JLFMVCBeanTableMapped mapped = this.entityCls.getAnnotation(JLFMVCBeanTableMapped.class);
		if (mapped == null) {
			this.tableName = this.entityCls.getSimpleName();
		} else {
			if (mapped.tableName() != null && mapped.tableName().length() > 0) {
				this.tableName = mapped.tableName();
			} else {
				this.tableName = this.entityCls.getSimpleName();
			}
			this.cacheKeyFormat = new StringBuffer("%s").append("_").append("%s").append("%d").toString();
			this.cacheReadIdLockKeyFormat = new StringBuffer("%s").append("_").append("%s").append("%d")
					.append("_readLock").toString();
			this.isCache = mapped.cache();
			this.seconds = mapped.seconds();
		}

		JLFMVCDaoMapping.addTableNameEntityMapping(tableName, entityCls);
	}

	/**
	 * 
	 * @Title: initFieldMapping
	 * @Description:初始化bean字段与get、set方法的映射、字段与class的映射关系
	 */
	private void initFieldMapping() {
		if (this.fieldGetMapping == null || this.fieldSetMapping == null) {
			Map<String, Method> fieldSetMappingTemp = new HashMap<String, Method>();
			Map<String, Method> fieldGetMappingTemp = new HashMap<String, Method>();
			Map<String, Class<?>> fieldNameEnumClsMappingTemp = new HashMap<String, Class<?>>();
			Class<ENTITY> cls = this.entityCls;
			for (Field field : fieldList) {
				String fieldName = field.getName();
				Class<?> fieldCls = field.getType();
				Method getMethod = ReflectUtil.createGetMothod(cls, fieldName);
				Method setMethod = ReflectUtil.createSetMothod(cls, fieldName, fieldCls);
				fieldGetMappingTemp.put(fieldName, getMethod);
				fieldSetMappingTemp.put(fieldName, setMethod);
				if (IEnum.class.isAssignableFrom(fieldCls)) {
					fieldNameEnumClsMappingTemp.put(fieldName, fieldCls);
				}

			}
			this.fieldGetMapping = fieldGetMappingTemp;
			this.fieldSetMapping = fieldSetMappingTemp;
			this.fieldNameEnumClsMapping = fieldNameEnumClsMappingTemp;
		}
	}

	/**
	 * 
	 * @Title: initSqls
	 * @Description:初始化sql
	 */
	private void initSqls() {
		initGetByIdSql();
		initDeleteSql();
	}

	/**
	 * 
	 * @Title: initGetByIdSql
	 * @Description:初始化getById sql
	 */
	private void initGetByIdSql() {
		String sql = new StringBuffer("select ").append(this.fieldStr).append(" from %s  where id = ?").toString();
		this.getByIdSql = String.format(sql, this.tableName);
		this.getByIdWithTableNameSql = sql;

	}

	/**
	 * 
	 * @Title: initDeleteSql
	 * @Description:删除delete sql
	 */
	private void initDeleteSql() {
		StringBuffer sqlBuffer = new StringBuffer("update ");
		sqlBuffer.append("%s");
		sqlBuffer.append(" set isDelete = ?,deleteNum = ?,version = version + 1 where id = ? and version = ?");
		String sql = sqlBuffer.toString();
		this.deleteWithTableNameSql = sql;
		this.deleteSql = String.format(sql, this.tableName);
	}

	/**
	 * 
	 * @Title: getById
	 * @Description:根据id获取实体
	 * @param id
	 * @return
	 */
	public ENTITY getById(Long id) {
		return getByIdExecute(id, getByIdSql, this.tableName);
	}

	/**
	 * 
	 * @Title: getById
	 * @Description:根据id获取实体,针对于分表处理
	 * @param id
	 * @param tableName
	 * @return
	 */
	public ENTITY getById(Long id, String tableName) {
		return getByIdExecute(id, String.format(getByIdWithTableNameSql, tableName), tableName);
	}

	/**
	 * 
	 * @Title: getByIdWithCache
	 * @Description: 根据id去缓存中查询数据
	 * @param id
	 * @param sql
	 * @param cacheKey
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	private ENTITY getByIdWithCache(Long id, String sql, String cacheKey, String dbName, String tableName) {
		ENTITY entity = null;
		entity = JLFCacheClient.get().getObj(cacheKey, this.entityCls);
		return entity;
	}

	/**
	 * 
	 * @Title: addReadLock
	 * @Description: 为id对应的数据创建读锁,防止缓存穿透
	 * @param id
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	private boolean addReadLock(Long id, String dbName, String tableName) {
		String cacheReadIdLockKey = String.format(cacheReadIdLockKeyFormat, dbName, tableName, id);
		return JLFCacheClient.get().setnx(cacheReadIdLockKey, id.toString(), 3);
	}

	/**
	 * 
	 * @Title: getByIdWithDatabase
	 * @Description: 根据id去数据库中查询数据
	 * @param id
	 * @param sql
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	private ENTITY getByIdWithDatabase(Long id, String sql, String dbName, String tableName) {
		ResultSet rs = getRs(sql, id);
		try {
			if (rs.next()) {
				return ResultSetToBean(rs);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: getByIdExecute
	 * @Description: 根据id获取实体的执行
	 * @param id
	 * @param sql
	 * @param tableName
	 * @return
	 */
	private ENTITY getByIdExecute(Long id, String sql, String tableName) {

		String dbName = getDbName();

		if (isCache) {
			String cacheKey = String.format(cacheKeyFormat, dbName, tableName, id);
			ENTITY entity = null;
			while (true) {
				entity = getByIdWithCache(id, sql, cacheKey, dbName, tableName);
				if (entity != null) {
					if (entity.isBlack()) { // 判断是否为黑名单,如果是黑名单,返回null
						return null;
					} else {
						return entity;
					}
				}
				boolean addReadLockFlg = addReadLock(id, dbName, tableName);
				if (!addReadLockFlg) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
					continue;
				}
				entity = getByIdWithDatabase(id, sql, dbName, tableName);
				if (entity == null) {
					try {
						entity = this.entityCls.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						throw new JLFException(e);
					}
					entity.setId(id);
					entity.setBlack(true);
					JLFCacheClient.get().save(cacheKey, entity, 60);

					return null;
				} else if (BooleanType.TRUE.equals(entity.getIsDelete())) {
					try {
						entity = this.entityCls.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						throw new JLFException(e);
					}
					entity.setId(id);
					entity.setIsDelete(BooleanType.TRUE);
					entity.setBlack(true);
					JLFCacheClient.get().save(cacheKey, entity);

					return null;
				} else {
					JLFCacheClient.get().save(cacheKey, entity, seconds);

				}
			}
		}
		return getByIdWithDatabase(id, sql, dbName, tableName);

	}

	/**
	 * 
	 * @Title: getByIdAndVersion
	 * @Description:根据id和版本号获取实体
	 * @param id
	 * @return
	 */
	public ENTITY getByIdAndVersion(Long id, Long version) {
		return getByIdAndVersion(id, version, this.tableName);
	}

	/**
	 * 
	 * @Title: getByIdAndVersion
	 * @Description:根据id和版本号获取实体,针对于分表处理
	 * @param id
	 * @param version
	 * @param tableName
	 * @return
	 */
	public ENTITY getByIdAndVersion(Long id, Long version, String tableName) {
		ENTITY ENTITY = null;
		if (tableName == null || tableName.length() == 0) {
			ENTITY = getById(id);
		} else {
			ENTITY = getById(id, tableName);
		}

		if (ENTITY == null) {
			return null;
		}
		if (ENTITY.getVersion() != version) {
			throw new JLFException("数据已已过期");
		}
		return ENTITY;
	}

	/**
	 * @Title: save
	 * @Description:保存实体
	 * @param ENTITY
	 * @return
	 */
	public ENTITY save(ENTITY ENTITY) {
		return save(ENTITY, this.tableName);

	}

	/**
	 * 
	 * @Title: save
	 * @Description:保存实体,针对于分表处理
	 * @param ENTITY
	 * @param tableName
	 * @return
	 */
	public ENTITY save(ENTITY ENTITY, String tableName) {
		try {
			JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
			Long sessionUserId = -1l;
			if (sessionBean != null) {
				sessionUserId = sessionBean.getUserId();
			}
			Date now = new Date();
			if (ENTITY.getCreateUserId() == null) {
				ENTITY.setCreateUserId(sessionUserId);
				ENTITY.setUpdateUserId(sessionUserId);
			}
			ENTITY.setCreateTime(now);
			ENTITY.setUpdateTime(now);
			StringBuffer sql = new StringBuffer("insert into ");
			sql.append(tableName);
			StringBuffer fields = new StringBuffer(" ( ");
			StringBuffer placeholder = new StringBuffer(" ( ");
			List<Object> values = new ArrayList<Object>();
			for (Field field : this.fieldList) {
				String fieldName = field.getName();
				Method getMethod = ReflectUtil.createGetMothod(this.entityCls, fieldName);
				Object value = getMethod.invoke(ENTITY);
				if (value != null && !value.equals("")) {
					Class<?> fieldCls = fieldNameEnumClsMapping.get(fieldName);
					if (fieldCls != null) {
						IEnum enums = (IEnum) value;
						Integer enumId = enums.getId();
						value = enumId;
					}
					values.add(value);
					fields.append(fieldName).append(",");
					placeholder.append("?,");
				}
			}
			fields = fields.replace(fields.length() - 1, fields.length(), ")");
			placeholder = placeholder.replace(placeholder.length() - 1, placeholder.length(), ")");
			sql.append(fields).append(" values ").append(placeholder);
			Object[] params = values.toArray(new Object[0]);
			PreparedStatement ps = getPs(sql.toString(), params);
			int updNum = execute(sql.toString(), ps, params);

			if (updNum != 1) {
				throw new JLFException("保存失败");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			ENTITY.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return ENTITY;

	}

	/**
	 * 
	 * @Title: update
	 * @Description:修改实体,默认忽略空值
	 * @param ENTITY
	 */
	public void update(ENTITY ENTITY) {
		update(ENTITY, true, this.tableName);
	}

	/**
	 * 
	 * @Title: update
	 * @Description:修改实体,默认忽略空值,针对于分表处理
	 * @param ENTITY
	 * @param tableName
	 */
	public void update(ENTITY ENTITY, String tableName) {
		update(ENTITY, true, tableName);
	}

	/**
	 * 
	 * @Title: update
	 * @Description:修改实体
	 * @param ENTITY
	 * @param ingoreNull
	 *            是否忽略空值
	 */
	public void update(ENTITY ENTITY, boolean ingoreNull) {
		update(ENTITY, ingoreNull, this.tableName);

	}

	/**
	 * 
	 * @Title: update
	 * @Description:修改实体,针对于分表处理
	 * @param ENTITY
	 * @param ingoreNull
	 * @param tableName
	 */
	public void update(ENTITY ENTITY, boolean ingoreNull, String tableName) {
		try {
			JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
			Long sessionUserId = -1l;
			if (sessionBean != null) {
				sessionUserId = sessionBean.getUserId();
			}
			Date now = new Date();
			ENTITY.setUpdateUserId(sessionUserId);
			ENTITY.setUpdateTime(now);
			StringBuffer sql = new StringBuffer("update ");
			sql.append(tableName).append(" set ");

			List<Object> values = new ArrayList<Object>();
			for (Field field : this.fieldList) {
				String fieldName = field.getName();
				Method getMethod = ReflectUtil.createGetMothod(this.entityCls, fieldName);
				Object value = getMethod.invoke(ENTITY);
				if (!ingoreNull || (ingoreNull && value != null && !value.equals(""))) {
					Class<?> fieldCls = fieldNameEnumClsMapping.get(fieldName);
					if (fieldCls != null) {
						IEnum enums = (IEnum) value;
						Integer enumId = enums.getId();
						value = enumId;
					}
					values.add(value);
					sql.append(fieldName).append("=").append("?,");
				}
			}

			sql.append("version = version + 1 where id = ? and version = ?");
			values.add(ENTITY.getId());
			values.add(ENTITY.getVersion());
			int updNum = execute(sql.toString(), values.toArray(new Object[0]));
			if (updNum != 1) {
				throw new JLFException("数据过期");
			}
			if (isCache) {
				String key = String.format(cacheKeyFormat, ENTITY.getId());
				JLFCacheClient.get().delete(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除实体
	 * @param id
	 * @param version
	 */
	public void delete(Long id, Long version) {
		deleteExecute(id, version, String.format(deleteSql, tableName));
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除实体,针对于分表处理
	 * @param id
	 * @param version
	 * @param tableName
	 */
	public void delete(Long id, Long version, String tableName) {
		deleteExecute(id, version, String.format(deleteWithTableNameSql, tableName));
	}

	/**
	 * 
	 * @Title: deleteExecute
	 * @Description:删除实体执行
	 * @param id
	 * @param version
	 * @param sql
	 */
	public void deleteExecute(Long id, Long version, String sql) {

		if (isCache) {
			String key = String.format(cacheKeyFormat, id);
			JLFCacheClient.get().delete(key);
		}

		if (execute(sql, BooleanType.TRUE.getId(), id, id, version) != 1) {
			throw new JLFException("数据过期");
		}

	}

	/**
	 * @Title: execute
	 * @Description:执行普通sql语句,返回影响的记录数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int execute(String sql, Object... params) {
		PreparedStatement ps = getPs(sql, params);
		return execute(sql, ps, params);
	}

	/**
	 * 
	 * @Title: execute
	 * @Description:执行普通sql语句,返回影响的记录数
	 * @param sql
	 * @param ps
	 * @param params
	 * @return
	 */
	public int execute(String sql, PreparedStatement ps, Object... params) {
		try {
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: getUnique
	 * @Description:执行普通sql语句,查询唯一bean
	 * @param sql
	 * @param params
	 * @return
	 */
	public ENTITY getUnique(String sql, Object... params) {
		ResultSet rs = getRs(sql, params);
		try {
			if (rs.next()) {
				return ResultSetToBean(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return null;

	}

	/**
	 * 
	 * @Title: getList
	 * @Description:执行普通sql语句,查询唯一list
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<ENTITY> getList(String sql, Object... params) {
		ResultSet rs = getRs(sql, params);
		List<ENTITY> list = new ArrayList<ENTITY>();
		try {
			while (rs.next()) {
				ENTITY ENTITY = ResultSetToBean(rs);
				list.add(ENTITY);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return list;
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:执行普通sql语句,查询分页信息,需要查询其它汇总信息
	 * @param selectSql
	 * @param totFieldSql
	 * @param fromSql
	 * @param pageNum
	 * @param pageSize
	 * @param params
	 * @return
	 */
	public JLFMVCPagingResponse<ENTITY> getPage(JLFMVCSqlBean sqlBean, Integer pageNum, Integer pageSize) {
		JLFMVCPagingResponse<ENTITY> page;
		try {
			Integer startNum = (pageNum - 1) * pageSize;
			String totSql = sqlBean.getTotSql();
			ResultSet totRs = getRs(totSql, sqlBean.getParams());
			totRs.next();
			Map<String, Object> totField = ResultSetToMap(totRs);
			Long totalNum = totRs.getLong("cnt");
			int totalPage = (int) (totalNum / pageSize);
			int remainder = (int) (totalNum % pageSize);
			if (remainder > 0) {
				totalPage = totalPage + 1;
			}
			String pageSql = sqlBean.getPageSql();
			ResultSet listRs = getPageRs(pageSql, sqlBean.getParams(), startNum, pageSize);
			List<ENTITY> beanList = new ArrayList<ENTITY>();
			while (listRs.next()) {
				ENTITY ENTITY = ResultSetToBean(listRs);
				beanList.add(ENTITY);
			}
			page = new JLFMVCPagingResponse<ENTITY>(totalNum, totalPage, totField, beanList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return page;
	}

	/**
	 * @Title: getPs
	 * @Description:获取PreparedStatement对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public PreparedStatement getPs(String sql, Object... params) {
		PreparedStatement ps;
		try {
			ps = getConn().prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			StringBuffer paramsStr = new StringBuffer();
			if (params != null) {
				int paramsLength = params.length;
				for (int i = 1; i <= paramsLength; i++) {
					Object param = params[i - 1];
					ps.setObject(i, param);
					paramsStr = paramsStr.append(param).append(",");
				}
			}
			LogUtil.get().debug("sql= {},params={}", sql, paramsStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return ps;
	}

	public PreparedStatement getPagePs(String sql, Object[] params, int startNum, int pageSize) {
		PreparedStatement ps;
		try {
			ps = getConn().prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			StringBuffer paramsStr = new StringBuffer();
			int paramsLength = 0;
			if (params != null) {
				paramsLength = params.length;
				for (int i = 1; i <= paramsLength; i++) {
					Object param = params[i - 1];
					ps.setObject(i, param);
					paramsStr = paramsStr.append(param).append(",");
				}
			}

			ps.setObject(paramsLength + 1, startNum);
			paramsStr = paramsStr.append(startNum).append(",");

			ps.setObject(paramsLength + 2, pageSize);
			paramsStr = paramsStr.append(pageSize).append(",");
			LogUtil.get().debug("sql= {},params={}", sql, paramsStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return ps;
	}

	/**
	 * @Title: getPs
	 * @Description:获取分页的PreparedStatement对象
	 * @param sql
	 * @param params
	 * @return
	 */
	/*
	 * private PreparedStatement getPagePs(String sql, int startNum, int
	 * pageSize, Object... params) { PreparedStatement ps; try {
	 * LogUtil.get().debug("sql= {}", sql); ps =
	 * getConn().prepareStatement(sql.toString()); int paramsLength = 0; if
	 * (params != null) { paramsLength = params.length; for (int i = 1; i <=
	 * paramsLength; i++) { Object param = params[i - 1]; ps.setObject(i,
	 * param); LogUtil.get().info("params{}= {},", i, param); } }
	 * ps.setObject(paramsLength + 1, startNum); LogUtil.get().info(
	 * "params{}= {},", paramsLength + 1, startNum); ps.setObject(paramsLength +
	 * 2, pageSize); LogUtil.get().info("params{}= {},", paramsLength + 2,
	 * pageSize); } catch (Exception e) { e.printStackTrace(); throw new
	 * JLFException(e); }
	 * 
	 * return ps; }
	 */

	/**
	 * @Title: getRs
	 * @Description:获取ResultSet对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet getRs(String sql, Object... params) {
		PreparedStatement ps = getPs(sql, params);
		try {
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	public ResultSet getPageRs(String sql, Object[] params, int startNum, int pageSize) {
		PreparedStatement ps = getPagePs(sql, params, startNum, pageSize);
		try {
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * @Title: ResultSetToBean
	 * @Description:将ResultSet结果集转成Bean
	 * @param rs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ENTITY ResultSetToBean(ResultSet rs) {

		/**
		 * entityCls与实体的map
		 */
		Map<Class<? extends JLFMVCEntity>, JLFMVCEntity> entityClsMap = new HashMap<Class<? extends JLFMVCEntity>, JLFMVCEntity>();

		/**
		 * 数据库表名与实体的map
		 */
		Map<String, JLFMVCEntity> tableNameEntityMap = new HashMap<String, JLFMVCEntity>();

		/**
		 * 数据库表名与dao的map
		 */
		Map<String, JLFMVCDao<?>> tableNameDaoMap = new HashMap<String, JLFMVCDao<?>>();

		ENTITY currEntity = null;
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();

			String tableName = null;
			for (int i = 1; i <= columnCount; i++) {

				/**
				 * 根据数据库表名找对应的实体与dao,先从当前的map中找,找不到则去JLFMVCDaoMapping找,并
				 * 将找到的结果放入当前map
				 */
				tableName = meta.getTableName(i);
				JLFMVCEntity entity = tableNameEntityMap.get(tableName);
				JLFMVCDao<?> dao = tableNameDaoMap.get(tableName);
				if (entity == null) {
					int tableNameSeparatorIndex = tableName.indexOf(tableNameSeparator);
					String baseTableName = tableName;
					if (tableName.indexOf(tableNameSeparator) >= 0) {
						baseTableName = tableName.substring(0, tableNameSeparatorIndex);
					}
					Class<? extends JLFMVCEntity> entityCls = JLFMVCDaoMapping.getEntityCls(baseTableName);
					if (entityCls == null) {
						LogUtil.get().debug("数据库表名{}未找到映射的实体,不封装实体", tableName);
						continue;
					}
					dao = JLFMVCDaoMapping.getDao(entityCls);
					entity = entityCls.newInstance();
					entityClsMap.put(entityCls, entity);
					tableNameEntityMap.put(tableName, entity);
					tableNameDaoMap.put(tableName, dao);
				}

				/**
				 * 获取字段名与字段值,并调用对应的dao,对实体的字段进行赋值
				 */
				String fieldName = meta.getColumnName(i);
				Object fieldValue = rs.getObject(meta.getColumnLabel(i));
				dao.fieldAssignment(fieldName, fieldValue, entity);

			}

			/**
			 * 从entityClsMap中找到当前dao对应的entity,找不到则新建,找到则从map中移除
			 */
			currEntity = (ENTITY) entityClsMap.get(this.entityCls);
			if (currEntity != null) {
				entityClsMap.remove(this.entityCls);
			} else {
				currEntity = this.entityCls.newInstance();
			}

			/**
			 * 遍历entityClsMap,将entityClsMap中的cls与entity放入currEntity的relationMap中
			 */
			for (Map.Entry<Class<? extends JLFMVCEntity>, JLFMVCEntity> entry : entityClsMap.entrySet()) {
				Class<? extends JLFMVCEntity> otherEntityCls = entry.getKey();
				JLFMVCEntity otherEntity = entry.getValue();
				currEntity.set(otherEntityCls, otherEntity);
			}

			/**
			 * 多返回的多个entity进行组合
			 */
			moreBeanGroup(currEntity);

		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return currEntity;
	}

	/**
	 * 
	 * @Title: fieldAssignment
	 * @Description: 为当前实体的字段赋值
	 * @param fieldName
	 * @param fieldValue
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public void fieldAssignment(String fieldName, Object fieldValue, JLFMVCEntity entity) {
		/**
		 * 值为空跳过赋值
		 */
		if (fieldValue == null) {
			return;
		}

		/**
		 * 看字段类型是否为枚举,如果是则将value转换为枚举
		 */
		Class<?> fieldCls = fieldNameEnumClsMapping.get(fieldName);
		if (fieldCls != null) {
			Integer id = (Integer) fieldValue;
			Class<? extends IEnum> enumCls = (Class<? extends IEnum>) fieldCls;
			IEnum enums = EnumUtil.getByID(enumCls, id);
			fieldValue = enums;
		}

		/**
		 * 调用setMethod方法赋值
		 */
		Method setMethod = this.fieldSetMapping.get(fieldName);
		if (setMethod != null) {
			try {
				setMethod.invoke(entity, fieldValue);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(setMethod.getName());
			}

		}
	}

	/**
	 * 
	 * @Title: ResultSetToMap
	 * @Description:将ResultSet结果集转成map
	 * @param rs
	 * @return
	 */
	public Map<String, Object> ResultSetToMap(ResultSet rs) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String key = meta.getColumnName(i);
				Object value = rs.getObject(key);
				map.put(key, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return map;
	}

	/**
	 * 
	 * @Title: moreBeanGroup
	 * @Description: 一个结果集返回多个实体时,通过此方法对多个实体进行组合
	 * @param entity
	 * @return
	 */
	public void moreBeanGroup(ENTITY entity) {
	}
}
