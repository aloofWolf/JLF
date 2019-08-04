package org.jlf.plugin.client.threadPool;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: JLFThreadPoolClient
 * @Description:ThreadPool�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFThreadPoolClient implements JLFPluginClient<JLFThreadPool> {

	private static JLFThreadPool api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFThreadPool get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFThreadPool>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
