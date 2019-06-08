package org.jlf.plugin.threadPool.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:ThreadPool客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFThreadPoolClient implements JLFPluginClient<JLFThreadPool> {

	private static JLFThreadPool api; // api实例
	private JLFPluginServer<JLFThreadPool> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFThreadPool>> JLFThreadPoolClient(SERVER server) throws Exception {
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
	public static JLFThreadPool get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFThreadPool> getServer() {
		return server;
	}

}
