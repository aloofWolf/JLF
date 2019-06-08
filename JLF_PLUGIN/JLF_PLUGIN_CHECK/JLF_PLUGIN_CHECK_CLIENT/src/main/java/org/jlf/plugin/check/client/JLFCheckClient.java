package org.jlf.plugin.check.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:CHECK客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFCheckClient implements JLFPluginClient<JLFCheck> {

	private static JLFCheck api; // api实例
	private JLFPluginServer<JLFCheck> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFCheck>> JLFCheckClient(SERVER server) throws Exception {
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
	public static JLFCheck get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFCheck> getServer() {
		return server;
	}

}
