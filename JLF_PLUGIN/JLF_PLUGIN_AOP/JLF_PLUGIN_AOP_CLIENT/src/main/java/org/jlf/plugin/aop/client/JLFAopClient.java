package org.jlf.plugin.aop.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFAopClient implements JLFPluginClient<JLFAop> {

	private static JLFAop api; // apiʵ��
	private JLFPluginServer<JLFAop> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFAop>> JLFAopClient(SERVER server) throws Exception {
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
	public static JLFAop get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFAop> getServer() {
		return server;
	}

}
