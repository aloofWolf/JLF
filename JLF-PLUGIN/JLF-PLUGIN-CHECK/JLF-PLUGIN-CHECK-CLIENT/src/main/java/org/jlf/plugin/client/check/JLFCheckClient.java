package org.jlf.plugin.client.check;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;

/**
 * 
 * @ClassName: JLFCheckClient
 * @Description:CHECK�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFCheckClient implements JLFPluginClient<JLFCheck> {

	private static JLFCheck api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
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
