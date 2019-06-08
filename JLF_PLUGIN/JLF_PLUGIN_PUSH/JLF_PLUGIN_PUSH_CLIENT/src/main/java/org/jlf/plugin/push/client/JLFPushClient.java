package org.jlf.plugin.push.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.push.server.api.JLFPush;

/**
 * 
 * @ClassName: JLFPushClient
 * @Description:JLFPush�ͻ���
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class JLFPushClient implements JLFPluginClient<JLFPush> {

	private static JLFPush api; // apiʵ��
	private JLFPluginServer<JLFPush> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFPushClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFPush>> JLFPushClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFPushClient�����ظ���ʼ��");
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
	public static JLFPush get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFPush> getServer() {
		return server;
	}

}
