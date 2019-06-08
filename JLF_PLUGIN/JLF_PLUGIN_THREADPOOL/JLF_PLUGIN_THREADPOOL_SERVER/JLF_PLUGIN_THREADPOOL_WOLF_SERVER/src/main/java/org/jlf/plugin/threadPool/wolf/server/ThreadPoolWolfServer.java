package org.jlf.plugin.threadPool.wolf.server;

import java.util.Set;

import org.jlf.core.server.JLFPluginServer;
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
	public JLFThreadPool get() {
		return new ThreadPoolWolfCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jStart() throws Exception {

	}

	@Override
	public void jStop() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void jreStart() throws Exception {
		// TODO Auto-generated method stub

	}
}
