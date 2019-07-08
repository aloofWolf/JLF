package org.jlf.plugin.cache.redisCluster.server;

import java.util.HashSet;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.cache.redisCluster.config.CacheRedisClusterConfig;
import org.jlf.plugin.cache.redisCluster.core.CacheRedisClusterAopDo;
import org.jlf.plugin.cache.redisCluster.core.CacheRedisClusterCore;
import org.jlf.plugin.cache.redisCluster.core.CacheRedisClusterPool;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.check.client.JLFCheckClient;

/**
 * 
 * @ClassName: CacheRedisClusterServer
 * @Description:CacheRedisClusterServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class CacheRedisClusterServer extends JLFPluginServer<JLFCache> {

	@Override
	public JLFCache getServerApi() {
		JLFAop aop = JLFAopClient.get();
		if (aop == null) {
			throw new JLFClientNoInitExecption(JLFAopClient.class);
		}
		return aop.getProxy(CacheRedisClusterCore.class, new CacheRedisClusterAopDo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFAopClient.class);
		set.add(JLFCheckClient.class);
		return set;
	}

	@Override
	public void initConfig() {
		String configFileName = JLFConfig.getPluginConfigName("cacheRedis");
		IniUtil ini = new IniUtil(configFileName);
		CacheRedisClusterConfig config = new CacheRedisClusterConfig(ini);
		CacheRedisClusterPool.init(config);
	}

}
