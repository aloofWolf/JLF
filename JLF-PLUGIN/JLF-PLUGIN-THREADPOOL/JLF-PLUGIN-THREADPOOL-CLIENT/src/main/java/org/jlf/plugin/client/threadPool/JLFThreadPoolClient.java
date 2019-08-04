package org.jlf.plugin.client.threadPool;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: JLFThreadPoolClient
 * @Description:ThreadPool客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFThreadPoolClient implements JLFPluginClient<JLFThreadPool> {

	private static JLFThreadPool api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
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
