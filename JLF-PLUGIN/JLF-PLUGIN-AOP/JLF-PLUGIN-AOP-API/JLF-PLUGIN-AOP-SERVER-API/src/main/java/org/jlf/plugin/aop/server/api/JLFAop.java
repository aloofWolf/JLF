package org.jlf.plugin.aop.server.api;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: JLFAop
 * @Description:AopApi
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public interface JLFAop extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "aop";

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
