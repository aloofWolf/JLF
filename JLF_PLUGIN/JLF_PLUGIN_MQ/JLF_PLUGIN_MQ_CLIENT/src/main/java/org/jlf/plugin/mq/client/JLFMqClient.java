package org.jlf.plugin.mq.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.mq.server.api.JLFMq;

public class JLFMqClient implements JLFPluginClient<JLFMq> {

	private static JLFMq api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFMq get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFMq>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
