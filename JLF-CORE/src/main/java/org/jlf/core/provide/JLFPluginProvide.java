package org.jlf.core.provide;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginProvide
 * @Description:插件服务提供端接口
 * @author Lone Wolf
 * @date 2019年8月10日
 * @param <SERVER_API>
 */
public interface JLFPluginProvide<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: getDefaultServer
	 * @Description:插件默认绑定的服务端
	 * @return
	 */
	public Class<? extends JLFPluginServer<SERVER_API>> getDefaultServer();

}
