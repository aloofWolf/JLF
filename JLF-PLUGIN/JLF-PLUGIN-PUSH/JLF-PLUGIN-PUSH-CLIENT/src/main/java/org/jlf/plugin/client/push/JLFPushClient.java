package org.jlf.plugin.client.push;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.push.server.api.JLFPush;

/**
 * 
 * @ClassName: JLFPushClient
 * @Description:JLFPush�ͻ���
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class JLFPushClient implements JLFPluginClient<JLFPush> {

	private static JLFPush api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
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
