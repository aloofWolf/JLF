package org.jlf.plugin.server.core.cache.redisCluster;

import org.jlf.plugin.server.core.cache.redisCluster.config.RedisClusterConfig;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @ClassName: RedisClusterPool
 * @Description:redisCluster连接池
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisClusterPool {

	private static JedisCluster jedis;

	public static void init(RedisClusterConfig config) {
		jedis = new JedisCluster(config.getHostAndPorts(), config.getJedisPoolConfig());
	}

	/**
	 * 
	 * @Title: getJedis
	 * @Description:从连接池中获取jedis
	 * @return
	 */
	protected static JedisCluster getJedis() {
		return jedis;
	}
}
