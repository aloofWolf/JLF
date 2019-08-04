package org.jlf.plugin.client.cache;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;

/**
 * 
 * @ClassName: JLFCacheClient
 * @Description:CACHE客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFCacheClient implements JLFPluginClient<JLFCache> {

	private static JLFCache api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
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
