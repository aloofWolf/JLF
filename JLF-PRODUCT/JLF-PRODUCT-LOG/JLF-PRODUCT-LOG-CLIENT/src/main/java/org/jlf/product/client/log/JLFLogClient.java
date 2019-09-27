package org.jlf.product.client.log;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.log.server.api.JLFLog;

/**
 * 
 * @ClassName: JLFLogClient
 * @Description: JLFLogClient
 * @author Lone Wolf
 * @date 2019年9月24日
 */
public class JLFLogClient implements JLFProductClient<JLFLog> {

	private static JLFLog api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFLog get() {
		return api;
	}

	@Override
	public <SERVER extends JLFProductServer<JLFLog>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
