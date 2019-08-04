package org.jlf.plugin.server.core.cache.redis;

import org.jlf.plugin.server.core.cache.redis.config.RedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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
	 * @Description:�����ӳ��л�ȡjedis
	 * @return
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
}
