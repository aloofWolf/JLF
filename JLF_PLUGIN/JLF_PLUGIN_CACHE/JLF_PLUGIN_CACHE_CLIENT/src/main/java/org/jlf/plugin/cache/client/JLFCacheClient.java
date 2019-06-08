package org.jlf.plugin.cache.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFCacheClient implements JLFPluginClient<JLFCache> {

	private static JLFCache api; // api实例
	private JLFPluginServer<JLFCache> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFCache>> JLFCacheClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFCacheClient不能重复初始化");
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
	public static JLFCache get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFCache> getServer() {
		return server;
	}

}
