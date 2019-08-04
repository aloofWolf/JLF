package org.jlf.plugin.provide.push;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.push.server.api.JLFPush;
import org.jlf.plugin.server.push.custom.PushCustomServer;

/**
 * 
 * @ClassName: JLFPushProvide
 * @Description:JLFPushProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFPushProvide implements JLFPluginProvide<JLFPush> {

	@Override
	public Class<? extends JLFPluginServer<JLFPush>> getDefaultServer() {
		return PushCustomServer.class;
	}

}
