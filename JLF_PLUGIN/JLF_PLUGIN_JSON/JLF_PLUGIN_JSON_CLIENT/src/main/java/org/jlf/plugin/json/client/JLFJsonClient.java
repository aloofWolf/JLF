package org.jlf.plugin.json.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

/**
 * 
 * @ClassName: JLFJsonClient
 * @Description:JSON客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFJsonClient implements JLFPluginClient<JLFJsonFactory> {

	private static JLFJsonFactory api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFJsonFactory get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFJsonFactory>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
