package org.jlf.plugin.client.mq;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.mq.server.api.JLFMq;

/**
 * 
 * @ClassName: JLFMqClient
 * @Description:JLFMqClient
 * @author Lone Wolf
 * @date 2019年7月23日
 */
public class JLFMqClient implements JLFPluginClient<JLFMq> {

	private static JLFMq api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFMq get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFMq>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}
	
	@Override
	public String getDefaultServerClsName() {
		return "org.jlf.plugin.server.mq.activeMq.ActiveMqServer";
	}

}
