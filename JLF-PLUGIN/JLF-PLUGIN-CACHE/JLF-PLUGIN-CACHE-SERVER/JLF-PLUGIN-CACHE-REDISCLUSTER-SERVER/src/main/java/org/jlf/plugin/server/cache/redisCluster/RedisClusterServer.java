package org.jlf.plugin.server.cache.redisCluster;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlf.common.util.IniContent;
import org.jlf.core.client.JLFPluginClient;
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
 * @date 2019年5月31日
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

	@Override
	public void start() {
		IniContent content = super.getConfig();
		start(content);
	}

	@Override
	public void reStart() {
		IniContent content = super.getConfig(true);
		start(content);
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动服务
	 * @param prop
	 */
	@SuppressWarnings("unchecked")
	public void start(IniContent content) {
		@SuppressWarnings("rawtypes")
		Map<String, Object> map = new HashMap<String, Object>((Map) content.getPros());
		RedisClusterConfig config = JLFCheckClient.get().check(map, RedisClusterConfig.class);
		config.setHostAndPosts(content.getSection("hosts").getPros());
		RedisClusterPool.init(config);
	}
}
