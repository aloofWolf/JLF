package org.jlf.plugin.server.core.cache.redisCluster;

import org.jlf.plugin.server.core.cache.redisCluster.config.RedisClusterConfig;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

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
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000); // 最大连接数
		poolConfig.setMaxIdle(32); // 最大空闲连接数
		poolConfig.setMaxWaitMillis(100 * 1000); // 最大等待时间
		poolConfig.setTestOnBorrow(true); // 检查连接可用性, 确保获取的redis实例可用
		jedis = new JedisCluster(config.getHostAndPorts(), poolConfig);
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
