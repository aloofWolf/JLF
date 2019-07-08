package org.jlf.plugin.cache.redisCluster.core;

import java.io.Serializable;
import java.util.Set;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.cache.server.api.JLFCache;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @ClassName: CacheRedisClusterCore
 * @Description:CacheRedisClusterCore
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class CacheRedisClusterCore implements JLFCache {

	protected JedisCluster jedis;

	@Override
	public void save(String key, String value) {
		jedis.set(key, value);
	}

	@Override
	public void save(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);

	}

	@Override
	public void save(String key, String value, int seconds) {
		jedis.set(key, value);
		jedis.expire(key, seconds);

	}

	@Override
	public void save(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);
		jedis.expire(key, seconds);
	}

	@Override
	public void update(String key, String value) {
		jedis.set(key, value);
	}

	@Override
	public void update(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);

	}

	@Override
	public void update(String key, String value, int seconds) {
		jedis.set(key, value);
		jedis.expire(key, seconds);

	}

	@Override
	public void update(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);
		jedis.expire(key, seconds);

	}

	@Override
	public String getString(String key) {
		return jedis.get(key);
	}

	@Override
	public <T extends Serializable> T getObj(String key, Class<T> cls) {
		String ser = jedis.get(key);
		if (ser == null) {
			return null;
		}
		T t = SerializeUtil.serializeToObject(ser, cls);
		return t;
	}

	@Override
	public void save(String key, String... values) {
		jedis.sadd(key, values);

	}

	@Override
	public void add(String key, String... values) {
		jedis.sadd(key, values);

	}

	@Override
	public void save(String key, int seconds, String... values) {
		jedis.sadd(key, values);
		jedis.expire(key, seconds);
	}

	@Override
	public void add(String key, int seconds, String... values) {
		jedis.sadd(key, values);
		jedis.expire(key, seconds);
	}

	@Override
	public int getArrSize(String key) {
		Set<String> set = jedis.smembers(key);
		if (set == null) {
			return 0;
		}
		return set.size();
	}

	@Override
	public void delete(String key) {
		jedis.del(key);

	}

	@Override
	public void setKeyPeriod(String key, int seconds) {
		jedis.expire(key, seconds);
	}

}
