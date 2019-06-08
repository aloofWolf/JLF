package org.jlf.plugin.mq.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.mq.server.api.JLFMq;

public class JLFMqClient implements JLFPluginClient<JLFMq> {

	private static JLFMq api; // api实例
	private JLFPluginServer<JLFMq> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFMq>> JLFMqClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFMqClient不能重复初始化");
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
	public static JLFMq get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFMq> getServer() {
		return server;
	}

}

