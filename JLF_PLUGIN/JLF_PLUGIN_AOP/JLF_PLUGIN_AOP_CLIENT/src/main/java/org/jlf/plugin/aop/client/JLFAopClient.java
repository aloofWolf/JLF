package org.jlf.plugin.aop.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFAopClient implements JLFPluginClient<JLFAop> {

	private static JLFAop api; // api实例
	private JLFPluginServer<JLFAop> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFAop>> JLFAopClient(SERVER server) throws Exception {
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
	public static JLFAop get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFAop> getServer() {
		return server;
	}

}
