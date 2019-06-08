package org.jlf.plugin.aop.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFSessionClient implements JLFPluginClient<JLFSession> {

	private static JLFSession api; // apiʵ��
	private JLFPluginServer<JLFSession> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFSession>> JLFSessionClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFSessionClient�����ظ���ʼ��");
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
	public static JLFSession get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFSession> getServer() {
		return server;
	}

}
