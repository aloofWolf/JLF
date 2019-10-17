package org.jlf.plugin.client.push;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.push.server.api.JLFPush;

/**
 * 
 * @ClassName: JLFPushClient
 * @Description:JLFPush客户端
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class JLFPushClient implements JLFPluginClient<JLFPush> {

	private static JLFPush api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFPush get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFPush>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}
	
	@Override
	public String getDefaultServerClsName() {
		return "org.jlf.plugin.server.push.custom.PushCustomServer";
	}

}
