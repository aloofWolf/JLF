package org.jlf.plugin.client.template;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.template.server.api.JLFTemplate;

/**
 * 
 * @ClassName: JLFTemplateClient
 * @Description:template客户端
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFTemplateClient implements JLFPluginClient<JLFTemplate> {

	private static JLFTemplate api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFTemplate get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFTemplate>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}
	
	@Override
	public String getDefaultServerClsName() {
		return "org.jlf.plugin.server.template.velocity.VelocityServer";
	}

}
