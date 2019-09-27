package org.jlf.product.client.log;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.log.server.api.JLFLog;

/**
 * 
 * @ClassName: JLFLogClient
 * @Description: JLFLogClient
 * @author Lone Wolf
 * @date 2019��9��24��
 */
public class JLFLogClient implements JLFProductClient<JLFLog> {

	private static JLFLog api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
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
