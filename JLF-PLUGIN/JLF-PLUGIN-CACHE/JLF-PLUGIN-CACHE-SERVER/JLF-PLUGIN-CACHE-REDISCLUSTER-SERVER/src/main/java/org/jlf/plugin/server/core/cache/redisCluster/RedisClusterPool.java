package org.jlf.plugin.server.core.cache.redisCluster;

import org.jlf.plugin.server.core.cache.redisCluster.config.RedisClusterConfig;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @ClassName: RedisClusterPool
 * @Description:redisCluster���ӳ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class RedisClusterPool {

	private static JedisCluster jedis;

	public static void init(RedisClusterConfig config) {
		jedis = new JedisCluster(config.getHostAndPorts(), config.getJedisPoolConfig());
	}

	/**
	 * 
	 * @Title: getJedis
	 * @Description:�����ӳ��л�ȡjedis
	 * @return
	 */
	protected static JedisCluster getJedis() {
		return jedis;
	}
}
