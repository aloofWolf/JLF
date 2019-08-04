package org.jlf.plugin.client.check;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:CHECK客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFCheckClient implements JLFPluginClient<JLFCheck> {

	private static JLFCheck api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFCheck get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFCheck>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
