package org.jlf.plugin.client.aop;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;

/**
 * 
 * @ClassName: JLFAopClient
 * @Description:AOP�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public class JLFAopClient implements JLFPluginClient<JLFAop> {

	private static JLFAop api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
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
