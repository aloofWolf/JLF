package org.jlf.core.client;

import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductClient
 * @Description:JLF产品客户端
 * @author Lone Wolf
 * @date 2019年6月2日
 * @param <SERVER_API>
 */
public interface JLFProductClient<SERVER_API extends JLFProductServerApi> {

	/**
	 * 
	 * @Title: bindServer
	 * @Description:绑定当前客户端的服务端
	 * @param server
	 */
	public <SERVER extends JLFProductServer<SERVER_API>> void bindServer(SERVER server);

}
