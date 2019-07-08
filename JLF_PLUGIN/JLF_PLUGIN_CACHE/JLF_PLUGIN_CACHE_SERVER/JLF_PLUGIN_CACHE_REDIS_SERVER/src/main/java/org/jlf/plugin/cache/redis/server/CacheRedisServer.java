package org.jlf.plugin.cache.redis.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.cache.redis.config.CacheRedisConfig;
import org.jlf.plugin.cache.redis.core.CacheRedisAopDo;
import org.jlf.plugin.cache.redis.core.CacheRedisCore;
import org.jlf.plugin.cache.redis.core.CacheRedisPool;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.server.api.JLFCheck;

/**
 * 
 * @ClassName: CacheRedisServer
 * @Description:CacheRedisServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class CacheRedisServer extends JLFPluginServer<JLFCache> {

	@Override
	public JLFCache getServerApi() {
		JLFAop aop = JLFAopClient.get();
		if(aop == null){
			throw new JLFClientNoInitExecption(JLFAopClient.class);
		}
		return aop.getProxy(CacheRedisCore.class, new CacheRedisAopDo());
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
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		if(ckeck == null){
			throw new JLFClientNoInitExecption(JLFCheckClient.class);
		}
		String configFileName = JLFConfig.getPluginConfigName("cacheRedis");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		CacheRedisConfig config = ckeck.check(map, CacheRedisConfig.class);
		CacheRedisPool.init(config);
	}

}
