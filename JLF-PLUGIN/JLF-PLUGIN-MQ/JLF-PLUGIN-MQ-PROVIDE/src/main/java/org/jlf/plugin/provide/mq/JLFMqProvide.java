package org.jlf.plugin.provide.mq;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.mq.server.api.JLFMq;
import org.jlf.plugin.server.mq.activeMq.ActiveMqServer;

/**
 * 
 * @ClassName: JLFMqProvide
 * @Description:JLFMqProvide
 * @author Lone Wolf
 * @date 2019��8��3��
 */
public class JLFMqProvide implements JLFPluginProvide<JLFMq> {

	@Override
	public Class<? extends JLFPluginServer<JLFMq>> getDefaultServer() {
		return ActiveMqServer.class;
	}

}
