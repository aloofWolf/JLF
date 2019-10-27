package org.jlf.plugin.client.rpc;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.rpc.server.api.JLFRpc;

/**
 * 
 * @ClassName: JLFRpcClient
 * @Description:JLFRpcClient
 * @author Lone Wolf
 * @date 2019年7月23日
 */
public class JLFRpcClient implements JLFPluginClient<JLFRpc> {

	private static JLFRpc api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
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
