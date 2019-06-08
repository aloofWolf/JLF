package org.jlf.plugin.json.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:JSON客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFJsonClient implements JLFPluginClient<JLFJsonFactory> {

	private static JLFJsonFactory api; // api实例
	private JLFPluginServer<JLFJsonFactory> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFJsonClient
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFJsonFactory>> JLFJsonClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFAopClient不能重复初始化");
		}
		api = server.get();
		this.server = server;
	}

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFJsonFactory get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFJsonFactory> getServer() {
		return server;
	}

}
