package org.jlf.product.quartz.wolf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.LogUtil;
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
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;
import org.jlf.plugin.dbpool.wolf.server.DbPoolWolfServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;
import org.jlf.plugin.session.cache.server.SessionCacheServer;
import org.jlf.plugin.threadPool.client.JLFThreadPoolClient;
import org.jlf.plugin.threadPool.wolf.server.ThreadPoolWolfServer;
import org.jlf.product.quartz.client.JLFQuartzClient;
import org.jlf.product.quartz.wolf.server.core.QuartzWolfServer;
import org.jlf.soa.mvc.server.JLFMVCServer;

/**
 * 
 * @ClassName: JLFManager
 * @Description:JLFManager
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFManager extends JLFCore {

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFAopClient(new AopCglibServer()));
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		plugins.add(new JLFDbPoolClient(new DbPoolWolfServer()));
		plugins.add(new JLFCacheClient(new CacheRedisServer()));
		plugins.add(new JLFSessionClient(new SessionCacheServer()));
		plugins.add(new JLFThreadPoolClient(new ThreadPoolWolfServer()));
		plugins.add(new JLFJsonClient(new FastJsonServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		List<JLFProductClient<?>> plugins = new ArrayList<JLFProductClient<?>>();
		plugins.add(new JLFQuartzClient(new QuartzWolfServer()));
		return plugins;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		List<SERVER> soas = new ArrayList<SERVER>();
		soas.add((SERVER) new JLFMVCServer());
		return soas;
	}
	
	@Override
    public void afterStartPlugins()throws Exception{
		LogUtil.get().debug("初始化子数据库开始。。。。。。。。。");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=1;i<=10;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("dbName", "wolf"+i);
			map.put("driver", "com.mysql.jdbc.Driver");
			map.put("url", "jdbc:mysql://39.108.166.34:3306/wolf"+i+"?useUnicode=true&characterEncoding=utf8");
			map.put("userName", "root");
			map.put("password", "yun4xue2wen2");
			list.add(map);
		}
		JLFDbPoolClient.get().initChildDatabases(list);
		LogUtil.get().debug("初始化子数据库结束。。。。。。。。。");
	}

}
