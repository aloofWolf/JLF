package org.jlf.plugin.server.template.velocity;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.server.core.template.velocity.VelocityCore;
import org.jlf.plugin.template.server.api.JLFTemplate;

/**
 * 
 * @ClassName: VelocityServer
 * @Description:Velocity�����
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class VelocityServer extends JLFPluginServer<JLFTemplate> {

	@Override
	public JLFTemplate getServerApi() {
		return new VelocityCore();
	}
}
