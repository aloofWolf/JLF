package org.jlf.plugin.cache.redis.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.cache.redis.config.CacheRedisConfig;
import org.jlf.plugin.cache.redis.core.CacheRedisAopDo;
import org.jlf.plugin.cache.redis.core.CacheRedisCore;
import org.jlf.plugin.cache.redis.core.CacheRedisPool;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.check.client.JLFCheckClient;

/**
 * 
 * @ClassName: CacheRedisServer
 * @Description:CacheRedisServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class CacheRedisServer extends JLFPluginServer<JLFCache> {

	@Override
	public JLFCache get() {
		return JLFAopClient.get().getProxy(CacheRedisCore.class, new CacheRedisAopDo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFAopClient.class);
		set.add(JLFCheckClient.class);
		return set;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getPluginConfigName("cacheRedis");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		CacheRedisConfig config = JLFCheckClient.get().check(map, CacheRedisConfig.class);
		CacheRedisPool.init(config);

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
