package org.jlf.plugin.provide.cache;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.server.api.JLFCache;
import org.jlf.plugin.server.cache.redis.RedisServer;

/**
 * 
 * @ClassName: JLFCacheProvide
 * @Description:JLFCacheProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFCacheProvide implements JLFPluginProvide<JLFCache> {

	@Override
	public Class<? extends JLFPluginServer<JLFCache>> getDefaultServer() {
		return RedisServer.class;
	}

}
