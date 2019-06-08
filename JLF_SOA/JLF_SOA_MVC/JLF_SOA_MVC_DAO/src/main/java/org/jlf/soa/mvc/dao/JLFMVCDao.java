package org.jlf.soa.mvc.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import org.jlf.plugin.aop.client.JLFSessionClient;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBeanMapped;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;

/**
 * 
 * @ClassName: JLFMVCDao
 * @Description:JAFMVCDao������
 * @author Lone Wolf
 * @date 2019��5��27��
 * @param <BEAN>
 */
public class JLFMVCDao<BEAN extends JLFMVCBean> {

	protected String fieldStr = null; // bean�ֶε��ַ�������,����getById��Insert����
	private List<Field> fieldList = null; // bean�ֶε�list����,����update����
	private Map<String, Class<?>> fieldNameEnumClsMapping = null; // �ֶ���ö�����͵�ӳ��
	private Map<String, Method> fieldSetMapping = null; // bean�ֶκ�set������ӳ��
	private Map<String, Method> fieldGetMapping = null; // bean�ֶκ�get������ӳ��
	private Class<BEAN> beanCls = null; // ��ǰbean��class
	protected String tableName = null; // ��ǰbean��Ӧ�����ݿ����
	protected boolean isCache = false;// ��ǰbean�Ƿ���Ҫ����
	protected int seconds = -1;// ������Ч��
	protected String cacheKey = null;// �����keyֵ

	/**
	 * 
	 * @Title: init
	 * @Description:��ʼ��dao��ر���
	 * @throws Exception
	 */
	public void init() throws Exception {
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
	 * @throws Exception
	 */
	public Connection getConn() throws Exception {
		String dbName = getDbName();
		return JLFDbPoolClient.get().getConn(dbName);

	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:��ȡ��ǰ��dbName
	 * @return
	 * @throws Exception
	 */
	public String getDbName() throws Exception {
		JLFMVCBeanMapped mapped = this.beanCls.getAnnotation(JLFMVCBeanMapped.class);
		String dbName = mapped.dbName();
		if ("?".equals(dbName)) {
			dbName = JLFMVCThreadLocal.getDbName();
		}
		return dbName;
	}

	/**
	 * 
	 * @Title: initBeanCls
	 * @Description:��ȡ��ǰbean��class����
	 * @return
	 */
	private void initBeanCls() throws Exception {
		this.beanCls = GenericityUtil.getObjGenerCls(this.getClass());
	}

	/**
	 * 
	 * @Title: getFieldStr
	 * @Description: ��ȡbean�ֶε��ַ�������
	 * @return
	 */
	private void initFields() throws Exception {
		this.fieldList = new ArrayList<Field>();
		List<Field> allFields = ReflectUtil.getAllFields(this.beanCls);
		StringBuffer fieldsSb = new StringBuffer();
		for (Field field : allFields) {
			String fieldName = field.getName();
			if(fieldName.equals("serialVersionUID")){
				continue;
			}
			JLFMVCBeanMapped mapped = field.getAnnotation(JLFMVCBeanMapped.class);
			if (mapped == null || !mapped.skipMapped()) {
				this.fieldList.add(field);
				fieldsSb.append(fieldName).append(",");
			}
		}
		this.fieldStr = fieldsSb.substring(0, fieldsSb.length() - 1);
	}

	/**
	 * 
	 * @Title: getTableName
	 * @Description:��ȡ��ǰbean��Ӧ�����ݿ����,������Ϣ
	 * @return
	 */
	private void initTableName() throws Exception {
		JLFMVCBeanMapped mapped = this.beanCls.getAnnotation(JLFMVCBeanMapped.class);
		if (mapped != null && mapped.tableName() != null && mapped.tableName().length() > 0) {
			this.tableName = mapped.tableName();
		} else {
			this.tableName = this.beanCls.getSimpleName();
		}
		//this.cacheKey = new StringBuffer(getDbName()).append("_").append(tableName).append("%s").toString();
		this.isCache = mapped.cache();
		this.seconds = mapped.seconds();
	}

	/**
	 * 
	 * @Title: initFieldMapping
	 * @Description:��ʼ��bean�ֶ���get��set������ӳ�䡢�ֶ���class��ӳ���ϵ
	 * @throws Exception
	 */
	private void initFieldMapping() throws Exception {
		if (this.fieldGetMapping == null || this.fieldSetMapping == null) {
			Map<String, Method> fieldSetMappingTemp = new HashMap<String, Method>();
			Map<String, Method> fieldGetMappingTemp = new HashMap<String, Method>();
			Map<String, Class<?>> fieldNameEnumClsMappingTemp = new HashMap<String, Class<?>>();
			Class<BEAN> cls = this.beanCls;
			for (Field field : fieldList) {
				String fieldName = field.getName();
				if(fieldName.equals("serialVersionUID")){
					continue;
				}
				JLFMVCBeanMapped mapped = field.getAnnotation(JLFMVCBeanMapped.class);
				if (mapped != null && mapped.skipMapped()) {
					continue;
				}
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
	 * @throws Exception
	 */
	public BEAN getById(Long id) throws Exception {
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
		if (rs.next()) {
			bean = ResultSetToBean(rs);
			if (isCache) {
				JLFCacheClient.get().save(key, bean);
			}
			return ResultSetToBean(rs);
		}
		return null;
	}

	/**
	 * @Title: save
	 * @Description:����ʵ��
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public BEAN save(BEAN bean) throws Exception {
		JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
		Long sessionUserId = -1l;
		if(sessionBean != null){
			sessionUserId = sessionBean.getUserId();
		}
		Date now = new Date();
		bean.setCreateUserId(sessionUserId);
		bean.setUpdateUserId(sessionUserId);
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
			Object value = values.get(i-1);
			ps.setObject(i, value);
			LogUtil.get().info("params{}= {},", i, value);
		}

		if (ps.executeUpdate() != 1) {
			throw new Exception("����ʧ��");
		}
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		Long id = rs.getLong(1);
		bean.setId(id);
		if (isCache) {
			String key = String.format(cacheKey, id);
			JLFCacheClient.get().save(key, bean);
		}
		return bean;

	}

	/**
	 * @Title: update
	 * @Description:�޸�ʵ��
	 * @param bean
	 * @throws Exception
	 */
	public void update(BEAN bean) throws Exception {
		JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
		Long sessionUserId = -1l;
		if(sessionBean != null){
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
			Object value = values.get(i-1);
			ps.setObject(i, value);
			LogUtil.get().info("params{}= {},", i, value);
		}
		ps.setLong(valuesSize + 1, bean.getId());
		ps.setLong(valuesSize + 2, bean.getVersion());
		LogUtil.get().info("params{}= {},", valuesSize + 1, bean.getId());
		LogUtil.get().info("params{}= {},", valuesSize + 2, bean.getVersion());
		if (ps.executeUpdate() != 1) {
			throw new Exception("���ݹ���");
		}
		if (isCache) {
			String key = String.format(cacheKey, bean.getId());
			JLFCacheClient.get().delete(key);
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��ʵ��
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	public void delete(Long id, Long version) throws Exception {
		StringBuffer sql = new StringBuffer("update ");
		sql.append(this.tableName);
		sql.append(" set isDelete = ?,deletedNum = ?,version = version + 1 where id = ? and version = ?");
		if (executePs(sql.toString(), BooleanType.TRUE.getId(), id, id, version) != 1) {
			throw new Exception("���ݹ���");
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
	 * @throws Exception
	 */
	public int execute(String sql, Object... params) throws Exception {
		PreparedStatement ps = getPs(sql, params);
		return ps.executeUpdate();
	}

	/**
	 * 
	 * @Title: getUnique
	 * @Description:ִ����ͨsql���,��ѯΨһbean
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public BEAN getUnique(String sql, Object... params) throws Exception {
		ResultSet rs = getRs(sql, params);
		if (rs.next()) {
			return ResultSetToBean(rs);
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
	 * @throws Exception
	 */
	public List<BEAN> getList(String sql, Object... params) throws Exception {
		ResultSet rs = getRs(sql, params);
		List<BEAN> list = new ArrayList<BEAN>();
		while (rs.next()) {
			BEAN bean = ResultSetToBean(rs);
			list.add(bean);
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
	 * @throws Exception
	 */
	public JLFMVCPage<BEAN> getPage(JLFMVCSqlBean sqlBean, Integer pageNum, Integer pageSize) throws Exception {
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
		JLFMVCPage<BEAN> page = new JLFMVCPage<BEAN>(totalNum, totalPage, totField, beanList);
		return page;
	}

	/**
	 * @Title: getPs
	 * @Description:��ȡPreparedStatement����
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public PreparedStatement getPs(String sql, Object... params) throws Exception {
		LogUtil.get().debug("sql= {}", sql);
		PreparedStatement ps = getConn().prepareStatement(sql.toString());
		int paramsLength = params.length;
		if (params != null) {
			for (int i = 1; i <= paramsLength; i++) {
				Object param = params[i - 1];
				ps.setObject(i, param);
				LogUtil.get().info("params{}= {},", i, param);
			}
		}
		return ps;
	}

	/**
	 * @Title: getPs
	 * @Description:��ȡ��ҳ��PreparedStatement����
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public PreparedStatement getPagePs(String sql, int startNum, int pageSize, Object... params) throws Exception {
		LogUtil.get().debug("sql= {}", sql);
		PreparedStatement ps = getConn().prepareStatement(sql.toString());
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
		return ps;
	}

	/**
	 * @Title: getRs
	 * @Description:��ȡResultSet����
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public ResultSet getRs(String sql, Object... params) throws Exception {
		PreparedStatement ps = getPs(sql, params);
		return ps.executeQuery();
	}

	/**
	 * 
	 * @Title: executePs
	 * @Description:��ȡִ��sql�Ľ��,����Ӱ��ļ�¼��
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int executePs(String sql, Object... params) throws Exception {
		return getPs(sql, params).executeUpdate();
	}

	/**
	 * @Title: ResultSetToBean
	 * @Description:��ResultSet�����ת��Bean
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public BEAN ResultSetToBean(ResultSet rs) throws Exception {

		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();
		BEAN bean = this.beanCls.newInstance();

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
		return bean;
	}

	/**
	 * 
	 * @Title: ResultSetToMap
	 * @Description:��ResultSet�����ת��map
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> ResultSetToMap(ResultSet rs) throws Exception {

		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();
		Map<String, Object> map = new HashMap<String, Object>();

		for (int i = 1; i <= columnCount; i++) {
			String key = meta.getColumnName(i);
			Object value = rs.getObject(key);
			map.put(key, value);
		}
		return map;
	}
}
