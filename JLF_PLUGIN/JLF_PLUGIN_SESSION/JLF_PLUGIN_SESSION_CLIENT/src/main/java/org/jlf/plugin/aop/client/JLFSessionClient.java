package org.jlf.plugin.aop.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFSessionClient implements JLFPluginClient<JLFSession> {

	private static JLFSession api; // api实例
	private JLFPluginServer<JLFSession> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFSession>> JLFSessionClient(SERVER server) throws Exception {
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
	public static JLFSession get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFSession> getServer() {
		return server;
	}

}
