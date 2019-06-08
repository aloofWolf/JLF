package org.jlf.product.quartz.client;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.quartz.server.api.JLFQuartz;

public class JLFQuartzClient implements JLFProductClient<JLFQuartz> {

	private static JLFQuartz api; // apiʵ��
	private JLFProductServer<JLFQuartz> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFProductServer<JLFQuartz>> JLFQuartzClient(SERVER server) throws Exception {
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
	public static JLFQuartz get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFProductServer<JLFQuartz> getServer() {
		return server;
	}

}
