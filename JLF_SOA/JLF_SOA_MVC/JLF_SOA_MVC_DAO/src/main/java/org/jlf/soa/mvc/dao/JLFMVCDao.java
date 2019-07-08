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
import org.jlf.common.exception.JLFException;
import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.dbPool.client.JLFDbPoolClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.session.client.JLFSessionClient;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;

/**
 * 
 * @ClassName: JLFMVCDao
 * @Description:JAFMVCDao基础类
 * @author Lone Wolf
 * @date 2019年5月27日
 * @param <BEAN>
 */
public class JLFMVCDao<BEAN extends JLFMVCBean> {

	protected String fieldStr = null; // bean字段的字符串集合,便于getById和Insert操作
	private List<Field> fieldList = null; // bean字段的list类型,便于update操作
	private Map<String, Class<?>> fieldNameEnumClsMapping = null; // 字段与枚举类型的映射
	private Map<String, Method> fieldSetMapping = null; // bean字段和set方法的映射
	private Map<String, Method> fieldGetMapping = null; // bean字段和get方法的映射
	private Class<BEAN> beanCls = null; // 当前bean的class
	protected String tableName = null; // 当前bean对应的数据库表名
	protected boolean isCache = false;// 当前bean是否需要缓存
	protected int seconds = -1;// 缓存有效期
	protected String cacheKey = null;// 缓存的key值

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
	 * @Title: getDbName
	 * @Description:获取当前的dbName
	 * @return
	 */
	public String getDbName() {
		String dbName = null;
		JLFMVCBeanTableMapped mapped = this.beanCls.getAnnotation(JLFMVCBeanTableMapped.class);
		if (mapped == null) {
			dbName = JLFDbPool.mainDbName;
		} else if ("?".equals(dbName)) {
			dbName = JLFMVCThreadLocal.getDbName();
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
		this.beanCls = GenericityUtil.getObjGenerCls(this.getClass());
	}

	/**
	 * 
	 * @Title: getFieldStr
	 * @Description: 获取bean字段的字符串集合
	 * @return
	 */
	private void initFields() {
		this.fieldList = new ArrayList<Field>();
		List<Field> allFields = ReflectUtil.getAllFields(this.beanCls);
		StringBuffer fieldsSb = new StringBuffer();
		for (Field field : allFields) {
			String fieldName = field.getName();
			if (fieldName.equals("serialVersionUID") || fieldName.equals("data")) {
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
		JLFMVCBeanTableMapped mapped = this.beanCls.getAnnotation(JLFMVCBeanTableMapped.class);
		if (mapped == null) {
			this.tableName = this.beanCls.getSimpleName();
			return;
		}
		if (mapped.tableName() != null && mapped.tableName().length() > 0) {
			this.tableName = mapped.tableName();
		} else {
			this.tableName = this.beanCls.getSimpleName();
		}
		this.cacheKey = new StringBuffer("%s").append("_").append(tableName).append("%s").toString();
		this.isCache = mapped.cache();
		this.seconds = mapped.seconds();
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
			Class<BEAN> cls = this.beanCls;
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
	 * @Title: getById
	 * @Description:根据id获取实体
	 * @param id
	 * @return
	 */
	public BEAN getById(Long id) {
		BEAN bean = null;
		String key = null;
		if (isCache) {
			key = String.format(cacheKey, id);
			bean = JLFCacheClient.get().getObj(key, this.beanCls);
			if (bean != null) {
				return bean;
			}
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(this.fieldStr);
		sql.append(" from ").append(this.tableName).append(" where id = ? and isDelete = ?");
		ResultSet rs = getRs(sql.toString(), id, BooleanType.FALSE.getId());
		try {
			if (rs.next()) {
				bean = ResultSetToBean(rs);
				if (isCache) {
					JLFCacheClient.get().save(key, bean);
				}
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
	 * @Title: getById
	 * @Description:根据id和版本号获取实体
	 * @param id
	 * @return
	 */
	public BEAN getByIdAndVersion(Long id, Long version) {
		BEAN bean = getById(id);
		if (bean == null) {
			return null;
		}
		if (bean.getVersion() != version) {
			throw new JLFException("版本号已过期");
		}
		return bean;
	}

	/**
	 * @Title: save
	 * @Description:保存实体
	 * @param bean
	 * @return
	 */
	public BEAN save(BEAN bean) {
		try {
			JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
			Long sessionUserId = -1l;
			if (sessionBean != null) {
				sessionUserId = sessionBean.getUserId();
			}
			Date now = new Date();
			if (bean.getCreateUserId() == null) {
				bean.setCreateUserId(sessionUserId);
				bean.setUpdateUserId(sessionUserId);
			}
			bean.setCreateTime(now);
			bean.setUpdateTime(now);
			StringBuffer sql = new StringBuffer("insert into ");
			sql.append(this.tableName);
			StringBuffer fields = new StringBuffer(" ( ");
			StringBuffer placeholder = new StringBuffer(" ( ");
			List<Object> values = new ArrayList<Object>();
			for (Field field : this.fieldList) {
				String fieldName = field.getName();
				Method getMethod = ReflectUtil.createGetMothod(this.beanCls, fieldName);
				Object value = getMethod.invoke(bean);
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
			PreparedStatement ps = getConn().prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			LogUtil.get().debug("sql= {}", sql);
			for (int i = 1; i <= values.size(); i++) {
				Object value = values.get(i - 1);
				ps.setObject(i, value);
				LogUtil.get().info("params{}= {},", i, value);
			}

			if (ps.executeUpdate() != 1) {
				throw new JLFException("保存失败");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			bean.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return bean;

	}

	/**
	 * @Title: update
	 * @Description:修改实体
	 * @param bean
	 */
	public void update(BEAN bean) {
		try {
			JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
			Long sessionUserId = -1l;
			if (sessionBean != null) {
				sessionUserId = sessionBean.getUserId();
			}
			Date now = new Date();
			bean.setUpdateUserId(sessionUserId);
			bean.setUpdateTime(now);
			StringBuffer sql = new StringBuffer("update ");
			sql.append(this.tableName).append(" set ");

			List<Object> values = new ArrayList<Object>();
			for (Field field : this.fieldList) {
				String fieldName = field.getName();
				Method getMethod = ReflectUtil.createGetMothod(this.beanCls, fieldName);
				Object value = getMethod.invoke(bean);
				if (value != null && !value.equals("")) {
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
			PreparedStatement ps = getConn().prepareStatement(sql.toString());
			LogUtil.get().info("sql= {}", sql);
			int valuesSize = values.size();
			for (int i = 1; i <= valuesSize; i++) {
				Object value = values.get(i - 1);
				ps.setObject(i, value);
				LogUtil.get().info("params{}= {},", i, value);
			}
			ps.setLong(valuesSize + 1, bean.getId());
			ps.setLong(valuesSize + 2, bean.getVersion());
			LogUtil.get().info("params{}= {},", valuesSize + 1, bean.getId());
			LogUtil.get().info("params{}= {},", valuesSize + 2, bean.getVersion());
			if (ps.executeUpdate() != 1) {
				throw new JLFException("数据过期");
			}
			if (isCache) {
				String key = String.format(cacheKey, bean.getId());
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
		StringBuffer sql = new StringBuffer("update ");
		sql.append(this.tableName);
		sql.append(" set isDelete = ?,deletedNum = ?,version = version + 1 where id = ? and version = ?");
		if (executePs(sql.toString(), BooleanType.TRUE.getId(), id, id, version) != 1) {
			throw new JLFException("数据过期");
		}
		if (isCache) {
			String key = String.format(cacheKey, id);
			JLFCacheClient.get().delete(key);
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
	public BEAN getUnique(String sql, Object... params) {
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
	public List<BEAN> getList(String sql, Object... params) {
		ResultSet rs = getRs(sql, params);
		List<BEAN> list = new ArrayList<BEAN>();
		try {
			while (rs.next()) {
				BEAN bean = ResultSetToBean(rs);
				list.add(bean);
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
	public JLFMVCPage<BEAN> getPage(JLFMVCSqlBean sqlBean, Integer pageNum, Integer pageSize) {
		JLFMVCPage<BEAN> page;
		try {
			Integer startNum = (pageNum - 1) * pageSize;
			String totFieldSql = sqlBean.getTotFieldSql();
			ResultSet totRs = getRs(totFieldSql, sqlBean.getParams());
			totRs.next();
			Map<String, Object> totField = ResultSetToMap(totRs);
			Long totalNum = totRs.getLong("cnt");
			int totalPage = (int) (totalNum / pageSize);
			int remainder = (int) (totalNum % pageSize);
			if (remainder > 0) {
				totalPage = totalPage + 1;
			}
			String pageSql = sqlBean.getPageSql();
			ResultSet listRs = getRs(pageSql, startNum, pageSize, sqlBean.getParams());
			List<BEAN> beanList = new ArrayList<BEAN>();
			while (listRs.next()) {
				BEAN bean = ResultSetToBean(listRs);
				beanList.add(bean);
			}
			page = new JLFMVCPage<BEAN>(totalNum, totalPage, totField, beanList);
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
			LogUtil.get().debug("sql= {}", sql);
			ps = getConn().prepareStatement(sql.toString());
			int paramsLength = params.length;
			if (params != null) {
				for (int i = 1; i <= paramsLength; i++) {
					Object param = params[i - 1];
					ps.setObject(i, param);
					LogUtil.get().info("params{}= {},", i, param);
				}
			}
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
	public PreparedStatement getPagePs(String sql, int startNum, int pageSize, Object... params) {
		PreparedStatement ps;
		try {
			LogUtil.get().debug("sql= {}", sql);
			ps = getConn().prepareStatement(sql.toString());
			int paramsLength = 0;
			if (params != null) {
				paramsLength = params.length;
				for (int i = 1; i <= paramsLength; i++) {
					Object param = params[i - 1];
					ps.setObject(i, param);
					LogUtil.get().info("params{}= {},", i, param);
				}
			}
			ps.setObject(paramsLength + 1, startNum);
			LogUtil.get().info("params{}= {},", paramsLength + 1, startNum);
			ps.setObject(paramsLength + 2, pageSize);
			LogUtil.get().info("params{}= {},", paramsLength + 2, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return ps;
	}

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

	/**
	 * 
	 * @Title: executePs
	 * @Description:获取执行sql的结果,返回影响的记录数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executePs(String sql, Object... params) {
		try {
			return getPs(sql, params).executeUpdate();
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
	public BEAN ResultSetToBean(ResultSet rs) {
		BEAN bean;
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			bean = this.beanCls.newInstance();

			for (int i = 1; i <= columnCount; i++) {
				String fieldName = meta.getColumnName(i);
				Object value = rs.getObject(fieldName);
				if (value == null) {
					continue;
				}
				Class<?> fieldCls = fieldNameEnumClsMapping.get(fieldName);
				if (fieldCls != null) {
					Integer id = (Integer) value;
					Class<? extends IEnum> enumCls = (Class<? extends IEnum>) fieldCls;
					IEnum enums = EnumUtil.getByID(enumCls, id);
					value = enums;
				}
				Method setMethod = this.fieldSetMapping.get(fieldName);
				bean.set(fieldName, value);
				if (setMethod != null) {
					try {
						setMethod.invoke(bean, value);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(setMethod.getName());
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return bean;
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
}
