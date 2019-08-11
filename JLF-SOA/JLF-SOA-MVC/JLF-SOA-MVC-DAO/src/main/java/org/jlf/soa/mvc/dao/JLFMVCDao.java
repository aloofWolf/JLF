package org.jlf.soa.mvc.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.DateUtil;
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
import org.jlf.soa.mvc.dao.blacklist.JLFMVCDaoBlackList;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;


/**
 * 
 * @ClassName: JLFMVCDao
 * @Description:JAFMVCDao������
 * @author Lone Wolf
 * @date 2019��5��27��
 * @param <ENTITY>
 */
@JLFMVCBean(generate=JLFMVCDaoGenerate.class)
public abstract class JLFMVCDao<ENTITY extends JLFMVCEntity> {

	protected String fieldStr = null; // bean�ֶε��ַ�������,����getById��Insert����
	private List<Field> fieldList = null; // bean�ֶε�list����,����update����
	private Map<String, Class<?>> fieldNameEnumClsMapping = null; // �ֶ���ö�����͵�ӳ��
	private Map<String, Method> fieldSetMapping = null; // bean�ֶκ�set������ӳ��
	private Map<String, Method> fieldGetMapping = null; // bean�ֶκ�get������ӳ��
	private Class<ENTITY> beanCls = null; // ��ǰbean��class
	protected String tableName = null; // ��ǰbean��Ӧ�����ݿ����
	protected boolean isCache = false;// ��ǰbean�Ƿ���Ҫ����
	protected int seconds = -1;// ������Ч��
	protected String cacheKey = null;// �����keyֵ

	/**
	 * 
	 * @Title: init
	 * @Description:��ʼ��dao��ر���
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
	 * @Description:��ȡ��ǰ�߳�����
	 * @return
	 */
	public Connection getConn() {
		String dbName = getDbName();
		return JLFDbPoolClient.get().getConn(dbName);

	}
	
	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ��ǰ�߳�����
	 * @return
	 */
	public Connection getConn(String dbName) {
		return JLFDbPoolClient.get().getConn(dbName);

	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:��ȡ��ǰ��dbName
	 * @return
	 */
	public String getDbName() {
		String dbName = null;
		JLFMVCBeanTableMapped mapped = this.beanCls.getAnnotation(JLFMVCBeanTableMapped.class);
		if (mapped == null) {
			dbName = JLFDbPool.mainDbName;
		} else if ("?".equals(dbName)) {
			dbName = JLFMVCThreadLocal.getDbName();
		} else if(mapped.dbName() == null || mapped.dbName().equals("")){
			dbName = JLFDbPool.mainDbName;
		}else{
			dbName = mapped.dbName();
		}
		return dbName;
	}

	/**
	 * 
	 * @Title: initBeanCls
	 * @Description:��ȡ��ǰbean��class����
	 * @return
	 */
	private void initBeanCls() {
		this.beanCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
	}

	/**
	 * 
	 * @Title: getFieldStr
	 * @Description: ��ȡbean�ֶε��ַ�������
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
	 * @Description:��ȡ��ǰbean��Ӧ�����ݿ����,������Ϣ
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
		this.cacheKey = new StringBuffer("%s").append("_").append(tableName).append("%d").toString();
		this.isCache = mapped.cache();
		this.seconds = mapped.seconds();
	}

	/**
	 * 
	 * @Title: initFieldMapping
	 * @Description:��ʼ��bean�ֶ���get��set������ӳ�䡢�ֶ���class��ӳ���ϵ
	 */
	private void initFieldMapping() {
		if (this.fieldGetMapping == null || this.fieldSetMapping == null) {
			Map<String, Method> fieldSetMappingTemp = new HashMap<String, Method>();
			Map<String, Method> fieldGetMappingTemp = new HashMap<String, Method>();
			Map<String, Class<?>> fieldNameEnumClsMappingTemp = new HashMap<String, Class<?>>();
			Class<ENTITY> cls = this.beanCls;
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
	 * @Description:����id��ȡʵ��
	 * @param id
	 * @return
	 */
	public ENTITY getById(Long id) {
		return getById(id, this.tableName);
	}

	/**
	 * 
	 * @Title: getById
	 * @Description:����id��ȡʵ��,����ڷֱ���
	 * @param id
	 * @param tableName
	 * @return
	 */
	public ENTITY getById(Long id, String tableName) {
		
		String dbName = getDbName();
		if(JLFMVCDaoBlackList.isExist(dbName, tableName, id)){
			return null;
		}
		ENTITY ENTITY = null;
		String key = null;
		if (isCache) {
			key = String.format(cacheKey, dbName,id);
			ENTITY = JLFCacheClient.get().getObj(key, this.beanCls);
			if (ENTITY != null) {
				return ENTITY;
			}
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select ").append(this.fieldStr);
		sql.append(" from ").append(tableName).append(" where id = ?");
		ResultSet rs = getRs(sql.toString(), id);
		try {
			if (rs.next()) {
				ENTITY = ResultSetToBean(rs);
				if(BooleanType.TRUE.equals(ENTITY.getIsDelete())){
					JLFMVCDaoBlackList.addBlack(dbName, tableName, id);
					return null;
				}
				if (isCache) {
					JLFCacheClient.get().save(key, ENTITY);
				}
				return ResultSetToBean(rs);
			}
			Date expireTime = DateUtil.getDateAfterMinute(3);
			JLFMVCDaoBlackList.addBlack(dbName, tableName, id,expireTime);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return null;
	}

	/**
	 * 
	 * @Title: getByIdAndVersion
	 * @Description:����id�Ͱ汾�Ż�ȡʵ��
	 * @param id
	 * @return
	 */
	public ENTITY getByIdAndVersion(Long id, Long version) {
		return getByIdAndVersion(id, version, this.tableName);
	}

	/**
	 * 
	 * @Title: getByIdAndVersion
	 * @Description:����ڷֱ���
	 * @param id
	 * @param version
	 * @param tableName
	 * @return
	 */
	public ENTITY getByIdAndVersion(Long id, Long version, String tableName) {
		ENTITY ENTITY = getById(id, tableName);
		if (ENTITY == null) {
			return null;
		}
		if (ENTITY.getVersion() != version) {
			throw new JLFException("�������ѹ���");
		}
		return ENTITY;
	}

	/**
	 * @Title: save
	 * @Description:����ʵ��
	 * @param ENTITY
	 * @return
	 */
	public ENTITY save(ENTITY ENTITY) {
		return save(ENTITY, this.tableName);

	}

	/**
	 * 
	 * @Title: save
	 * @Description:����ʵ��,����ڷֱ���
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
				Method getMethod = ReflectUtil.createGetMothod(this.beanCls, fieldName);
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
			int updNum = execute(sql.toString(), ps,params);

			if (updNum != 1) {
				throw new JLFException("����ʧ��");
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
	 * @Description:�޸�ʵ��,Ĭ�Ϻ��Կ�ֵ
	 * @param ENTITY
	 */
	public void update(ENTITY ENTITY) {
		update(ENTITY, true,this.tableName);
	}
	
	/**
	 * 
	    * @Title: update
	    * @Description:�޸�ʵ��,Ĭ�Ϻ��Կ�ֵ,����ڷֱ���
	    * @param ENTITY
	    * @param tableName
	 */
	public void update(ENTITY ENTITY,String tableName) {
		update(ENTITY, true,tableName);
	}

	/**
	 * 
	 * @Title: update
	 * @Description:�޸�ʵ��
	 * @param ENTITY
	 * @param ingoreNull
	 *            �Ƿ���Կ�ֵ
	 */
	public void update(ENTITY ENTITY, boolean ingoreNull) {
		update(ENTITY,ingoreNull,this.tableName);

	}
	
	/**
	 * 
	    * @Title: update
	    * @Description:�޸�ʵ��,����ڷֱ���
	    * @param ENTITY
	    * @param ingoreNull
	    * @param tableName
	 */
	public void update(ENTITY ENTITY, boolean ingoreNull,String tableName) {
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
				Method getMethod = ReflectUtil.createGetMothod(this.beanCls, fieldName);
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
				throw new JLFException("���ݹ���");
			}
			if (isCache) {
				String key = String.format(cacheKey, ENTITY.getId());
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
	 * @Description:ɾ��ʵ��
	 * @param id
	 * @param version
	 */
	public void delete(Long id, Long version) {
		delete(id,version,this.tableName);
	}
	
	/**
	 * 
	    * @Title: delete
	    * @Description:ɾ��ʵ��,����ڷֱ���
	    * @param id
	    * @param version
	    * @param tableName
	 */
	public void delete(Long id, Long version,String tableName) {
		StringBuffer sql = new StringBuffer("update ");
		sql.append(tableName);
		sql.append(" set isDelete = ?,deletedNum = ?,version = version + 1 where id = ? and version = ?");
		if (execute(sql.toString(), BooleanType.TRUE.getId(), id, id, version) != 1) {
			throw new JLFException("���ݹ���");
		}
		if (isCache) {
			String key = String.format(cacheKey, id);
			JLFCacheClient.get().delete(key);
		}
	}

	/**
	 * @Title: execute
	 * @Description:ִ����ͨsql���,����Ӱ��ļ�¼��
	 * @param sql
	 * @param params
	 * @return
	 */
	public int execute(String sql, Object... params) {
		PreparedStatement ps = getPs(sql, params);
		return execute(sql,ps,params);
	}
	
	/**
	 * 
	    * @Title: execute
	    * @Description:ִ����ͨsql���,����Ӱ��ļ�¼��
	    * @param sql
	    * @param ps
	    * @param params
	    * @return
	 */
	public int execute(String sql,PreparedStatement ps, Object... params) {
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
	 * @Description:ִ����ͨsql���,��ѯΨһbean
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
	 * @Description:ִ����ͨsql���,��ѯΨһlist
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
	 * @Description:ִ����ͨsql���,��ѯ��ҳ��Ϣ,��Ҫ��ѯ����������Ϣ
	 * @param selectSql
	 * @param totFieldSql
	 * @param fromSql
	 * @param pageNum
	 * @param pageSize
	 * @param params
	 * @return
	 */
	public JLFMVCPage<ENTITY> getPage(JLFMVCSqlBean sqlBean, Integer pageNum, Integer pageSize) {
		JLFMVCPage<ENTITY> page;
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
			List<ENTITY> beanList = new ArrayList<ENTITY>();
			while (listRs.next()) {
				ENTITY ENTITY = ResultSetToBean(listRs);
				beanList.add(ENTITY);
			}
			page = new JLFMVCPage<ENTITY>(totalNum, totalPage, totField, beanList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return page;
	}

	/**
	 * @Title: getPs
	 * @Description:��ȡPreparedStatement����
	 * @param sql
	 * @param params
	 * @return
	 */
	public PreparedStatement getPs(String sql, Object... params) {
		PreparedStatement ps;
		try {
			ps = getConn().prepareStatement(sql.toString());
			StringBuffer paramsStr = new StringBuffer();
			if (params != null) {
				int paramsLength = params.length;
				for (int i = 1; i <= paramsLength; i++) {
					Object param = params[i - 1];
					ps.setObject(i, param);
					paramsStr = paramsStr.append(param).append(",");
				}
			}
			LogUtil.get().debug("sql= {},params={}",sql,paramsStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return ps;
	}
	
	

	/**
	 * @Title: getPs
	 * @Description:��ȡ��ҳ��PreparedStatement����
	 * @param sql
	 * @param params
	 * @return
	 */
	/*private PreparedStatement getPagePs(String sql, int startNum, int pageSize, Object... params) {
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
	}*/

	/**
	 * @Title: getRs
	 * @Description:��ȡResultSet����
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
	 * @Title: ResultSetToBean
	 * @Description:��ResultSet�����ת��Bean
	 * @param rs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ENTITY ResultSetToBean(ResultSet rs) {
		ENTITY ENTITY;
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			ENTITY = this.beanCls.newInstance();

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
				ENTITY.set(fieldName, value);
				if (setMethod != null) {
					try {
						setMethod.invoke(ENTITY, value);
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

		return ENTITY;
	}

	/**
	 * 
	 * @Title: ResultSetToMap
	 * @Description:��ResultSet�����ת��map
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
