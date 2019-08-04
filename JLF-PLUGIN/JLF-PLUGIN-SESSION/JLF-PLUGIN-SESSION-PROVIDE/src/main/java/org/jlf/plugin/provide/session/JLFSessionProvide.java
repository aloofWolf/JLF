package org.jlf.plugin.provide.session;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.server.session.cache.SessionCacheServer;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: JLFSessionProvide
 * @Description:JLFSessionProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFSessionProvide implements JLFPluginProvide<JLFSession> {

	@Override
	public Class<? extends JLFPluginServer<JLFSession>> getDefaultServer() {
		return SessionCacheServer.class;
	}

}
