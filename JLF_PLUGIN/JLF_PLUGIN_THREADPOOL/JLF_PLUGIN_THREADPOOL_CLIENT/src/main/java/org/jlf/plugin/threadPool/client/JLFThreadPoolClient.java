package org.jlf.plugin.threadPool.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:ThreadPool�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFThreadPoolClient implements JLFPluginClient<JLFThreadPool> {

	private static JLFThreadPool api; // apiʵ��
	private JLFPluginServer<JLFThreadPool> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFThreadPool>> JLFThreadPoolClient(SERVER server) throws Exception {
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
	public static JLFThreadPool get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFThreadPool> getServer() {
		return server;
	}

}
