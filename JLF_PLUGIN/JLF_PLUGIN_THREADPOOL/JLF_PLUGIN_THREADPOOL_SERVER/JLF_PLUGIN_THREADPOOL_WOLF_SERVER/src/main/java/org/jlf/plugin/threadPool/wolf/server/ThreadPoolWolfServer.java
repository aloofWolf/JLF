package org.jlf.plugin.threadPool.wolf.server;

import java.util.HashSet;
import java.util.Set;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbPool.client.JLFDbPoolClient;
import org.jlf.plugin.threadPool.api.JLFThreadPool;
import org.jlf.plugin.threadPool.wolf.server.core.ThreadPoolWolfCore;

/**
 * 
 * @ClassName: ThreadPoolWolfServer
 * @Description:ThreadPoolWolfServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ28ÈÕ
 */
public class ThreadPoolWolfServer extends JLFPluginServer<JLFThreadPool> {

	@Override
	public JLFThreadPool getServerApi() {
		return new ThreadPoolWolfCore();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFDbPoolClient.class);
		return set;
	}
}
