package org.jlf.plugin.server.cache.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
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
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class RedisServer extends JLFPluginServer<JLFCache> {

	private static final String configFileName = "redis.ini";

	@Override
	public JLFCache getServerApi() {
		JLFAop aop = JLFAopClient.get();
		if (aop == null) {
			throw new JLFClientNoInitExecption(JLFAopClient.class);
		}
		return aop.getProxy(RedisCore.class, new RedisAopDo());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		if (ckeck == null) {
			throw new JLFClientNoInitExecption(JLFCheckClient.class);
		}
		IniUtil ini = new IniUtil(JLFConfig.getPluginConfigFilePath(configFileName));
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		RedisConfig config = ckeck.check(map, RedisConfig.class);
		RedisPool.init(config);
	}

}
