package org.jlf.plugin.client.dbPool;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolClient
 * @Description:DbPool客户端
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFDbPoolClient implements JLFPluginClient<JLFDbPool> {

	private static JLFDbPool api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
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
