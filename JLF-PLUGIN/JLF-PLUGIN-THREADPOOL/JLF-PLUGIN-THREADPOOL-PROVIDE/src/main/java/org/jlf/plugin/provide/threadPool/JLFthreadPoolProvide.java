package org.jlf.plugin.provide.threadPool;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.server.threadPool.custom.ThreadPoolCustomServer;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: JLFthreadPoolProvide
 * @Description:JLFthreadPoolProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFthreadPoolProvide implements JLFPluginProvide<JLFThreadPool> {

	@Override
	public Class<? extends JLFPluginServer<JLFThreadPool>> getDefaultServer() {
		return ThreadPoolCustomServer.class;
	}

}
