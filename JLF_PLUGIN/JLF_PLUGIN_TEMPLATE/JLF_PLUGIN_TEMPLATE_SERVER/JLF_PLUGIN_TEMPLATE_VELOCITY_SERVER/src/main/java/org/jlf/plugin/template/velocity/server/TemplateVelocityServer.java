package org.jlf.plugin.template.velocity.server;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.template.server.api.JLFTemplate;
import org.jlf.plugin.template.velocity.server.core.VelocityCore;

/**
 * 
 * @ClassName: TemplateVelocityServer
 * @Description:TemplateVelocity服务端
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class TemplateVelocityServer extends JLFPluginServer<JLFTemplate> {

	@Override
	public JLFTemplate getServerApi() {
		return new VelocityCore();
	}
}
