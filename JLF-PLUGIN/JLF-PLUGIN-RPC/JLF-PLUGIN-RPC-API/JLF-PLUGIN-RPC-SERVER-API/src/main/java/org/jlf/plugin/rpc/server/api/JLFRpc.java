package org.jlf.plugin.rpc.server.api;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFRpc
 * @Description: JLFRpc
 * @author Lone Wolf
 * @date 2019年10月26日
 */
public interface JLFRpc extends JLFPluginServerApi{

	public static final String PLUGIN_NAME = "rpc";

	/**
	 * 
	 * @Title: get
	 * @Description: 根据接口获取实现类对象
	 * @param apiCls
	 * @return
	 */
	public <API, IMPL extends API> IMPL get(Class<API> apiCls);

}
