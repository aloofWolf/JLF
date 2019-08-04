package org.jlf.plugin.client.dbPool;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolClient
 * @Description:DbPool�ͻ���
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class JLFDbPoolClient implements JLFPluginClient<JLFDbPool> {

	private static JLFDbPool api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFDbPool get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFDbPool>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
