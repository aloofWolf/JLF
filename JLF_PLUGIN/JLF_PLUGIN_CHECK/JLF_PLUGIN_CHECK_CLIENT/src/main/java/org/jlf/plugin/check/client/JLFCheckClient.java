package org.jlf.plugin.check.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:CHECK�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFCheckClient implements JLFPluginClient<JLFCheck> {

	private static JLFCheck api; // apiʵ��
	private JLFPluginServer<JLFCheck> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFCheck>> JLFCheckClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFAopClient�����ظ���ʼ��");
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
	public static JLFCheck get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFCheck> getServer() {
		return server;
	}

}
