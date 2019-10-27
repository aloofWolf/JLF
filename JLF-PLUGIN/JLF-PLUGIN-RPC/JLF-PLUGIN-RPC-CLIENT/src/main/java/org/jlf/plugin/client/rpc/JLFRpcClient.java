package org.jlf.plugin.client.rpc;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.rpc.server.api.JLFRpc;

/**
 * 
 * @ClassName: JLFRpcClient
 * @Description:JLFRpcClient
 * @author Lone Wolf
 * @date 2019��7��23��
 */
public class JLFRpcClient implements JLFPluginClient<JLFRpc> {

	private static JLFRpc api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFRpc get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFRpc>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}

	@Override
	public String getDefaultServerClsName() {
		return "org.jlf.plugin.server.rpc.dubbo.DubboServer";
	}

}
