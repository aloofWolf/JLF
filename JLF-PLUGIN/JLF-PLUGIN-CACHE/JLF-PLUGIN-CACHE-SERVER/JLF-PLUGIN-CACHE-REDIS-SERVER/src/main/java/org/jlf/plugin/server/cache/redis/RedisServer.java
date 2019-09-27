package org.jlf.plugin.server.cache.redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.aop.JLFAopClient;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.server.core.cache.redis.RedisAopDo;
import org.jlf.plugin.server.core.cache.redis.RedisCore;
import org.jlf.plugin.server.core.cache.redis.RedisPool;
import org.jlf.plugin.server.core.cache.redis.config.RedisConfig;

/**
 * 
 * @ClassName: RedisServer
 * @Description:RedisServer
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisServer extends JLFPluginServer<JLFCache> {

	@Override
	public JLFCache getServerApi() {
		JLFAop aop = JLFAopClient.get();
		return aop.getProxy(RedisCore.class, new RedisAopDo());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFAopClient.class);
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;
		
	}
	
	@Override
	public void start() {
		Properties prop = super.getConfig();
		start(prop);
	}

	@Override
	public void reStart() {
		Properties prop = super.getConfig(true);
		start(prop);
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动服务
	 * @param prop
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start(Properties prop) {
		JLFCheck ckeck = JLFCheckClient.get();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		RedisConfig config = ckeck.check(map, RedisConfig.class);
		RedisPool.init(config);
	}

}
