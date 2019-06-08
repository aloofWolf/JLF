package org.jlf.plugin.mq.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.mq.server.api.JLFMq;

public class JLFMqClient implements JLFPluginClient<JLFMq> {

	private static JLFMq api; // apiʵ��
	private JLFPluginServer<JLFMq> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFMq>> JLFMqClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFMqClient�����ظ���ʼ��");
		}
		api = server.get();
		this.server = server;
	}

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFMq get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFMq> getServer() {
		return server;
	}

}

