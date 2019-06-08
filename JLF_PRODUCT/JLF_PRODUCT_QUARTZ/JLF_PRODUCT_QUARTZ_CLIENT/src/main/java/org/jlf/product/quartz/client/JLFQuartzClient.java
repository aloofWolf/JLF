package org.jlf.product.quartz.client;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.quartz.server.api.JLFQuartz;

public class JLFQuartzClient implements JLFProductClient<JLFQuartz> {

	private static JLFQuartz api; // api实例
	private JLFProductServer<JLFQuartz> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFProductServer<JLFQuartz>> JLFQuartzClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFSessionClient不能重复初始化");
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
	public static JLFQuartz get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFProductServer<JLFQuartz> getServer() {
		return server;
	}

}
