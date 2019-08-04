package org.jlf.plugin.client.aop;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public class JLFAopClient implements JLFPluginClient<JLFAop> {

	private static JLFAop api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFAop get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFAop>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}

}
