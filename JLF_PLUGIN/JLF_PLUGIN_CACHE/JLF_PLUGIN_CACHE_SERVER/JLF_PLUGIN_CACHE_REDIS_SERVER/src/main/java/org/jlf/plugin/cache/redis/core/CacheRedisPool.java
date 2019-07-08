package org.jlf.plugin.cache.redis.core;

import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.plugin.cache.redis.config.CacheRedisConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName: CacheRedisPool
 * @Description:redis���ӳ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class CacheRedisPool {

	private static JedisPool jedisPool;

	public static void init(CacheRedisConfig config) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000); // ���������
		poolConfig.setMaxIdle(32); // ������������
		poolConfig.setMaxWaitMillis(100 * 1000); // ���ȴ�ʱ��
		poolConfig.setTestOnBorrow(true); // ������ӿ�����, ȷ����ȡ��redisʵ������
		Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
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
