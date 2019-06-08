package org.jlf.plugin.push.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.push.server.api.JLFPush;

/**
 * 
 * @ClassName: JLFPushClient
 * @Description:JLFPush客户端
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class JLFPushClient implements JLFPluginClient<JLFPush> {

	private static JLFPush api; // api实例
	private JLFPluginServer<JLFPush> server; // 绑定服务端

	/**
	 * 
	 * 创建一个新的实例 JLFPushClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFPush>> JLFPushClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFPushClient不能重复初始化");
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
	public static JLFPush get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFPush> getServer() {
		return server;
	}

}
