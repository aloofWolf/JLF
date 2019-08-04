package org.jlf.plugin.provide.template;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.server.template.velocity.VelocityServer;
import org.jlf.plugin.template.server.api.JLFTemplate;

/**
 * 
 * @ClassName: JLFTemplateProvide
 * @Description:JLFTemplateProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFTemplateProvide implements JLFPluginProvide<JLFTemplate> {

	@Override
	public Class<? extends JLFPluginServer<JLFTemplate>> getDefaultServer() {
		return VelocityServer.class;
	}

}
