package org.jlf.plugin.json.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:JSON�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFJsonClient implements JLFPluginClient<JLFJsonFactory> {

	private static JLFJsonFactory api; // apiʵ��
	private JLFPluginServer<JLFJsonFactory> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFJsonClient
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFJsonFactory>> JLFJsonClient(SERVER server) throws Exception {
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
	public static JLFJsonFactory get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFJsonFactory> getServer() {
		return server;
	}

}
