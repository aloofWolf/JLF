package org.jlf.plugin.session.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: JLFSessionClient
 * @Description:SESSION客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFSessionClient implements JLFPluginClient<JLFSession> {

	private static JLFSession api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFSession get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFSession>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}
}
