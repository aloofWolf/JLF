package org.jlf.plugin.server.cache.redisCluster;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.server.core.cache.redisCluster.RedisClusterCore;
import org.jlf.plugin.server.core.cache.redisCluster.RedisClusterPool;
import org.jlf.plugin.server.core.cache.redisCluster.config.RedisClusterConfig;

/**
 * 
 * @ClassName: RedisClusterServer
 * @Description:RedisClusterServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class RedisClusterServer extends JLFPluginServer<JLFCache> {

	@Override
	public JLFCache getServerApi() {
		return new RedisClusterCore();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initConfig() {
		Properties prop = super.getConfig();
		@SuppressWarnings("rawtypes")
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		RedisClusterConfig config = JLFCheckClient.get().check(map, RedisClusterConfig.class);
		config.setHostAndPosts(JLFConfig.getPluginConfig(JLFCache.PLUGIN_NAME+"-hosts"));
		RedisClusterPool.init(config);
	}

}
