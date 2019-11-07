package org.jlf.plugin.server.core.cache.redis;

import org.jlf.plugin.server.core.cache.redis.config.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @ClassName: RedisPool
 * @Description:redis���ӳ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class RedisPool {

	private static JedisPool jedisPool;

	public static void init(RedisConfig config) {
		jedisPool = new JedisPool(config.getJedisPoolConfig(), config.getIp(), config.getPort());
	}

	/**
	 * 
	 * @Title: getJedis
	 * @Description:�����ӳ��л�ȡjedis
	 * @return
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
}
