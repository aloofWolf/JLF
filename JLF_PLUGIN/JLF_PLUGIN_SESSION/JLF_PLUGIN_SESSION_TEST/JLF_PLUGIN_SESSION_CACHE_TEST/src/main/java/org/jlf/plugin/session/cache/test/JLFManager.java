package org.jlf.plugin.session.cache.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.aop.cglib.server.AopCglibServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.aop.client.JLFSessionClient;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.cache.redis.server.CacheRedisServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;
import org.jlf.plugin.session.cache.server.SessionCacheServer;

/**
 * 
 * @ClassName: JLFManager
 * @Description:JLFManager
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ4ÈÕ
 */
public class JLFManager extends JLFCore {

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFAopClient(new AopCglibServer()));
		plugins.add(new JLFCacheClient(new CacheRedisServer()));
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		plugins.add(new JLFSessionClient(new SessionCacheServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}

}
