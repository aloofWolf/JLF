package org.jlf.plugin.template.client;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.template.server.api.JLFTemplate;

/**
 * 
 * @ClassName: JLFTemplateClient
 * @Description:template�ͻ���
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFTemplateClient implements JLFPluginClient<JLFTemplate> {

	private static JLFTemplate api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFTemplate get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFTemplate>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}

}
