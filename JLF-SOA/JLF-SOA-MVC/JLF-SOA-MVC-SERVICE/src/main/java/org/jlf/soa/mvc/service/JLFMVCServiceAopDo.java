package org.jlf.soa.mvc.service;

import java.lang.reflect.Method;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.user.api.JLFAopDo;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: JLFMVCServiceAopDo
 * @Description:JLFMVCServiceAop����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCServiceAopDo implements JLFAopDo<JLFMVCDbBean> {

	@Override
	public JLFMVCDbBean doBefore(Object obj, Method method, Object[] args) {
		JLFMVCDbBean bean = new JLFMVCDbBean();
		JLFMVCTrans trans = method.getAnnotation(JLFMVCTrans.class);
		if (trans != null) {
			String dbName = getDbName(trans);
			if (!JLFDbPoolClient.get().isOpenTrans(dbName)) {
				JLFDbPoolClient.get().openTrans(dbName);
				bean.isOpenTrans = true;
				bean.dbName = dbName;
				LogUtil.get().debug("{}����������", method.getName());
			}
		}
		return bean;

	}

	@Override
	public JLFMVCDbBean doAfter(Object obj, Method method, Object[] args, JLFMVCDbBean bean) {
		if (bean.isOpenTrans) {
			String dbName = bean.dbName;
			JLFDbPoolClient.get().commitTrans(dbName);
			LogUtil.get().debug("{}�����ύ����", method.getName());
		}
		return bean;

	}

	@Override
	public JLFMVCDbBean doException(Object obj, Method method, Object[] args, JLFMVCDbBean bean) {
		if (bean.isOpenTrans) {
			JLFDbPoolClient.get().rollbackTrans();
			LogUtil.get().debug("{}�����ع�����", method.getName());
		}
		return bean;

	}

	/**
	 * 
	 * @Title: getDbName
	 * @Description:��ȡdbName
	 * @param obj
	 * @return @
	 */
	private String getDbName(JLFMVCTrans trans) {
		String dbName = trans.dbName();
		if (dbName == null || dbName.length() == 0) {
			dbName = JLFDbPool.mainDbName;
		} else if (dbName.equals("?")) {
			dbName = JLFMVCThreadLocal.getDbName();
		}
		return dbName;
	}

}

class JLFMVCDbBean {
	boolean isOpenTrans;
	String dbName;
}