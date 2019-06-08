package org.jlf.plugin.dbpool.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbpool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolClient
 * @Description:DbPool客户端
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFDbPoolClient implements JLFPluginClient<JLFDbPool> {

	private static JLFDbPool api; // api实例
	private JLFPluginServer<JLFDbPool> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFDbPool>> JLFDbPoolClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("DbPoolClient不能重复初始化");
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
	public static JLFDbPool get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFDbPool> getServer() {
		return server;
	}

}
