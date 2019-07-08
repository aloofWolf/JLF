package org.jlf.plugin.session.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: JLFSessionClient
 * @Description:SESSION�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFSessionClient implements JLFPluginClient<JLFSession> {

	private static JLFSession api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
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
