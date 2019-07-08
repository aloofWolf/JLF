package org.jlf.plugin.cache.redis.core;

import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.plugin.cache.redis.config.CacheRedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName: CacheRedisPool
 * @Description:redis连接池
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class CacheRedisPool {

	private static JedisPool jedisPool;

	public static void init(CacheRedisConfig config) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000); // 最大连接数
		poolConfig.setMaxIdle(32); // 最大空闲连接数
		poolConfig.setMaxWaitMillis(100 * 1000); // 最大等待时间
		poolConfig.setTestOnBorrow(true); // 检查连接可用性, 确保获取的redis实例可用
		Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
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
