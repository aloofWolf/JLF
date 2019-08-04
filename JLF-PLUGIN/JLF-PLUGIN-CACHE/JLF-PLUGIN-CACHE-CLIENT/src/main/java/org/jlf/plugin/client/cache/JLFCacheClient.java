package org.jlf.plugin.client.cache;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;

/**
 * 
 * @ClassName: JLFCacheClient
 * @Description:CACHE�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFCacheClient implements JLFPluginClient<JLFCache> {

	private static JLFCache api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFCache get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFCache>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
