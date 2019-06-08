package org.jlf.soa.mvc.service;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.GenericityUtil;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.JLFMVCDaoStruc;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;

/**
 * 
 * @ClassName: JLFMVCService
 * @Description:JAFMVCService基础类
 * @author Lone Wolf
 * @date 2019年5月27日
 * @param <BEAN>
 * @param <DAO>
 */
public abstract class JLFMVCService<BEAN extends JLFMVCBean, DAO extends JLFMVCDao<BEAN>> {

	private Class<DAO> daoCls;
	protected DAO dao;

	/**
	 * 
	 * @Title: init
	 * @Description:初始化service相关变量
	 * @throws Exception
	 */
	public void init() throws Exception {
		initDaoCls();
		initDao();
	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:获取当前的dbName
	 * @return
	 * @throws Exception
	 */
	public String getDbName() throws Exception {
		return dao.getDbName();
	}

	/**
	 * 
	 * @Title: initDaoCls
	 * @Description:daoCls
	 * @throws Exception
	 */
	private void initDaoCls() throws Exception {
		this.daoCls = GenericityUtil.getObjGenerCls(this.getClass().getSuperclass(), 2);
	}

	/**
	 * 
	 * @Title: initDao
	 * @Description:dao
	 * @throws Exception
	 */
	private void initDao() throws Exception {
		this.dao = JLFMVCDaoStruc.getDao(daoCls);
	}

	/**
	 * 
	 * @Title: getById
	 * @Description:根据id获取实体
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public BEAN getById(Long id) throws Exception {
		return dao.getById(id);
	}

	@JLFMAVCConnection
	public BEAN getByIdAndVersion(Long id, Long version) throws Exception {
		BEAN bean = dao.getById(id);
		if (bean == null) {
			return null;
		}
		if (bean.getVersion() != version) {
			throw new JLFException("版本号已过期");
		}
		return bean;
	}

	/**
	 * 
	 * @Title: save
	 * @Description:保存实体
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public BEAN save(BEAN bean) throws Exception {
		bean = dao.save(bean);
		return bean;
	}

	/**
	 * 
	 * @Title: update
	 * @Description:修改实体
	 * @param bean
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void update(BEAN bean) throws Exception {
		dao.update(bean);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除实体
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void delete(Long id, Long version) throws Exception {
		dao.delete(id, version);
	}

}
