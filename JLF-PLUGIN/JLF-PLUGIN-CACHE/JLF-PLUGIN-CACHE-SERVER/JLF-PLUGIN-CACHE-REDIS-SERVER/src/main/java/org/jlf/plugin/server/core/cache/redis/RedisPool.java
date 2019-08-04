package org.jlf.plugin.server.core.cache.redis;

import org.jlf.plugin.server.core.cache.redis.config.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		if(config.getMaxTotal() != null){
			poolConfig.setMaxTotal(config.getMaxTotal());
		}
		
		if(config.getMaxIdle() != null){
			poolConfig.setMaxIdle(config.getMaxIdle());
		}
		
		if(config.getMaxWaitMillis() != null){
			poolConfig.setMaxWaitMillis(config.getMaxWaitMillis());
		}
		
		if(config.getTestOnBorrow() != null){
			poolConfig.setTestOnBorrow(config.getTestOnBorrow().isBln());
		}
		jedisPool = new JedisPool(poolConfig, config.getIp(), config.getPort());
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
