package org.jlf.plugin.server.core.cache.redisCluster;

import org.jlf.plugin.server.core.cache.redisCluster.config.RedisClusterConfig;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

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
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000); // ���������
		poolConfig.setMaxIdle(32); // ������������
		poolConfig.setMaxWaitMillis(100 * 1000); // ���ȴ�ʱ��
		poolConfig.setTestOnBorrow(true); // ������ӿ�����, ȷ����ȡ��redisʵ������
		jedis = new JedisCluster(config.getHostAndPorts(), poolConfig);
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
