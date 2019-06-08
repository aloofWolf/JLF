package org.jlf.soa.mvc.service;

import java.lang.reflect.Method;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.user.api.JLFAopDo;
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;

/**
 * 
 * @ClassName: JLFMVCServiceAopDo
 * @Description:JLFMVCServiceAop处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCServiceAopDo implements JLFAopDo<JLFMVCDbBean> {

	@Override
	public JLFMVCDbBean doBefore(Object obj, Method method, Object[] args) throws Exception {
		JLFMVCDbBean bean = new JLFMVCDbBean();
		JLFMAVCConnection conn = method.getAnnotation(JLFMAVCConnection.class);
		
		if (conn != null) {
			String dbName = getDbName(obj);
			if (!JLFDbPoolClient.get().isOpenConn(dbName)) {
				JLFDbPoolClient.get().openConn(dbName);
				bean.isOpenConn = true;
				LogUtil.get().debug("%s方法打开connection", method.getName());
			}
		}
		JLFMVCTrans trans = method.getAnnotation(JLFMVCTrans.class);
		if (trans != null) {
			String dbName = getDbName(obj);
			if (!JLFDbPoolClient.get().isOpenTrans(dbName)) {
				JLFDbPoolClient.get().openTrans(dbName);
				bean.isOpenTrans = true;
				LogUtil.get().debug("%s方法打开事物", method.getName());
			}
		}
		return bean;

	}

	@Override
	public JLFMVCDbBean doAfter(Object obj, Method method, Object[] args, JLFMVCDbBean bean) throws Exception {
		if (bean.isOpenTrans) {
			String dbName = getDbName(obj);
			JLFDbPoolClient.get().commitTrans(dbName);
			LogUtil.get().debug("%s方法提交事物", method.getName());
		} else if (bean.isOpenConn) {
			String dbName = getDbName(obj);
			JLFDbPoolClient.get().closeConn(dbName);
			LogUtil.get().debug("%s方法关闭connection", method.getName());
		}
		return bean;

	}

	@Override
	public JLFMVCDbBean doException(Object obj, Method method, Object[] args, JLFMVCDbBean bean) throws Exception {
		if (bean.isOpenTrans) {
			JLFDbPoolClient.get().rollbackTrans();
			LogUtil.get().debug("%s方法回滚事物", method.getName());
		} else if (bean.isOpenConn) {
			String dbName = getDbName(obj);
			JLFDbPoolClient.get().closeConn(dbName);
			LogUtil.get().debug("%s方法关闭connection", method.getName());
		}
		return bean;

	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:获取dbName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	private String getDbName(Object obj) throws Exception {
		JLFMVCService<?, ?> service = (JLFMVCService<?, ?>) obj;
		String dbName = service.getDbName();
		return dbName;
	}

}

class JLFMVCDbBean {
	boolean isOpenConn;
	boolean isOpenTrans;
}