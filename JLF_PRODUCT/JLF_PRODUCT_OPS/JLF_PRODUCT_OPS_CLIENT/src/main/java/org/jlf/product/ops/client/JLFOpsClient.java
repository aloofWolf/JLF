package org.jlf.product.ops.client;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.ops.server.api.JLFOps;
import org.jlf.product.ops.web.api.JLFOpsAction;

/**
 * 
 * @ClassName: JLFOpsClient
 * @Description:JLFOpsClient
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFOpsClient implements JLFProductClient<JLFOps, JLFOpsAction> {

	private static JLFOps api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFOps get() {
		return api;
	}

	@Override
	public <SERVER extends JLFProductServer<JLFOps, JLFOpsAction>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
