package org.jlf.plugin.dbpool.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbpool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolClient
 * @Description:DbPool�ͻ���
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class JLFDbPoolClient implements JLFPluginClient<JLFDbPool> {

	private static JLFDbPool api; // apiʵ��
	private JLFPluginServer<JLFDbPool> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFDbPool>> JLFDbPoolClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("DbPoolClient�����ظ���ʼ��");
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
	public static JLFDbPool get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFDbPool> getServer() {
		return server;
	}

}
