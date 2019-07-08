package org.jlf.plugin.cache.redisCluster.core;

import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.plugin.cache.redisCluster.config.CacheRedisClusterConfig;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName: CacheRedisClusterPool
 * @Description:redisCluster���ӳ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class CacheRedisClusterPool {

	private static JedisCluster jedis;

	public static void init(CacheRedisClusterConfig config) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000); // ���������
		poolConfig.setMaxIdle(32); // ������������
		poolConfig.setMaxWaitMillis(100 * 1000); // ���ȴ�ʱ��
		poolConfig.setTestOnBorrow(true); // ������ӿ�����, ȷ����ȡ��redisʵ������
		Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
		jedis = new JedisCluster(config.getHostAndPorts(), poolConfig);
	}

	/**
	 * 
	 * @Title: getJedis
	 * @Description:�����ӳ��л�ȡjedis
	 * @return
	 */
	public static JedisCluster getJedis() {
		return jedis;
	}
}
