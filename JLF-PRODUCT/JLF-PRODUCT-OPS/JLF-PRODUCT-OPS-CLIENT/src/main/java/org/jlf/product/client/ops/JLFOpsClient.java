package org.jlf.product.client.ops;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.ops.server.api.JLFOps;

/**
 * 
 * @ClassName: JLFOpsClient
 * @Description:JLFOpsClient
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFOpsClient implements JLFProductClient<JLFOps> {

	private static JLFOps api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFOps get() {
		return api;
	}

	@Override
	public <SERVER extends JLFProductServer<JLFOps>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
