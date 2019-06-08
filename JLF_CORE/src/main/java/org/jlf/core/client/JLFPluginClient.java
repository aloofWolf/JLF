package org.jlf.core.client;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginClient
 * @Description:JLF插件客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 * @param <API>
 */
public interface JLFPluginClient<API extends JLFIPlugin> {

	/**
	 * 
	 * @Title: getServer
	 * @Description:获取插件的绑定的server端
	 * @return
	 */
	public <SERVER extends JLFPluginServer<API>> SERVER getServer();

}
