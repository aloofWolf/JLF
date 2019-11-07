package org.jlf.plugin.server.core.cache.redis;

import org.jlf.plugin.server.core.cache.redis.config.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @ClassName: RedisPool
 * @Description:redis连接池
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisPool {

	private static JedisPool jedisPool;

	public static void init(RedisConfig config) {
		jedisPool = new JedisPool(config.getJedisPoolConfig(), config.getIp(), config.getPort());
	}

	/**
	 * 
	 * @Title: getJedis
	 * @Description:从连接池中获取jedis
	 * @return
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
}
