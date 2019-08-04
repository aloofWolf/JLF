package org.jlf.plugin.server.cache.redisCluster;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
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

	private static final String configFileName = "redisCluster.ini";

	@Override
	public JLFCache getServerApi() {
		return new RedisClusterCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initConfig() {
		IniUtil ini = new IniUtil(JLFConfig.getPluginConfigFilePath(configFileName));
		Properties prop = ini.getPros();
		@SuppressWarnings("rawtypes")
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		RedisClusterConfig config = JLFCheckClient.get().check(map, RedisClusterConfig.class);
		config.setHostAndPosts(ini.getSection("hosts"));
		RedisClusterPool.init(config);
	}

}
