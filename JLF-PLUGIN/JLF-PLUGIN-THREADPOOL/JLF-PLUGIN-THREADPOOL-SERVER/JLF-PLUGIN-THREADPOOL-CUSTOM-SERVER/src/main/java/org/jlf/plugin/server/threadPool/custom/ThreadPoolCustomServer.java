package org.jlf.plugin.server.threadPool.custom;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.server.core.threadPool.custom.ThreadPoolCustomCore;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: ThreadPoolCustomServer
 * @Description:ThreadPoolCustomServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ28ÈÕ
 */
public class ThreadPoolCustomServer extends JLFPluginServer<JLFThreadPool> {

	@Override
	public JLFThreadPool getServerApi() {
		return new ThreadPoolCustomCore();
	}
}
