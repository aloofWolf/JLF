package org.jlf.plugin.cache.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFCacheClient implements JLFPluginClient<JLFCache> {

	private static JLFCache api; // apiʵ��
	private JLFPluginServer<JLFCache> server; // �󶨷����

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFAopClient.
	 *
	 * @param server
	 * @throws Exception
	 */
	public <SERVER extends JLFPluginServer<JLFCache>> JLFCacheClient(SERVER server) throws Exception {
		if (api != null) {
			throw new Exception("JLFCacheClient�����ظ���ʼ��");
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
	public static JLFCache get() {
		return api;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JLFPluginServer<JLFCache> getServer() {
		return server;
	}

}
