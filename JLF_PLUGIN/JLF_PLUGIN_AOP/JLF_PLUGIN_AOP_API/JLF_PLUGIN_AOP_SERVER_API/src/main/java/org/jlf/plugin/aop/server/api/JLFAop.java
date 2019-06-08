package org.jlf.plugin.aop.server.api;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: JAFAop
 * @Description:AopApi
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public interface JLFAop extends JLFIPlugin {

	/**
	 * 
	 * @Title: getProxy
	 * @Description:��ȡ�������
	 * @param tCls
	 * @param aopDo
	 * @return
	 */
	public <T extends Object> T getProxy(Class<T> tCls, JLFAopDo<?> aopDo);

}
