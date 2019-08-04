package org.jlf.core.client;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginClient
 * @Description:JLF插件客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 * @param <SERVER_API>
 */
public interface JLFPluginClient<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: bindServer
	 * @Description:绑定当前客户端的服务端
	 * @param server
	 */
	public <SERVER extends JLFPluginServer<SERVER_API>> void bindServer(SERVER server);

}
