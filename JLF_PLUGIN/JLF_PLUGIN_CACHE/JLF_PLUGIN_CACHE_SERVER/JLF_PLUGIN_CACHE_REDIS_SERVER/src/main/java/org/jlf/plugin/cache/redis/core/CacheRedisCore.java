package org.jlf.plugin.cache.redis.core;

import java.io.Serializable;
import java.util.Set;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.cache.server.api.JLFCache;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName: CacheRedisCore
 * @Description:CacheRedisCore
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class CacheRedisCore implements JLFCache {

	protected Jedis jedis;

	@Override
	public void save(String key, String value) throws Exception {
		jedis.set(key, value);
	}

	@Override
	public void save(String key, Serializable bean) throws Exception {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);

	}

	@Override
	public void save(String key, String value, int seconds) throws Exception {
		jedis.set(key, value);
		jedis.expire(key, seconds);

	}

	@Override
	public void save(String key, Serializable bean, int seconds) throws Exception {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);
		jedis.expire(key, seconds);
	}

	@Override
	public void update(String key, String value) throws Exception {
		jedis.set(key, value);
	}

	@Override
	public void update(String key, Serializable bean) throws Exception {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);

	}

	@Override
	public void update(String key, String value, int seconds) throws Exception {
		jedis.set(key, value);
		jedis.expire(key, seconds);

	}

	@Override
	public void update(String key, Serializable bean, int seconds) throws Exception {
		String ser = SerializeUtil.serialize(bean);
		jedis.set(key, ser);
		jedis.expire(key, seconds);

	}

	@Override
	public String getString(String key) throws Exception {
		return jedis.get(key);
	}

	@Override
	public <T extends Serializable> T getObj(String key, Class<T> cls) throws Exception {
		String ser = jedis.get(key);
		if (ser == null) {
			return null;
		}
		T t = SerializeUtil.serializeToObject(ser, cls);
		return t;
	}

	@Override
	public void save(String key, String... values) throws Exception {
		jedis.sadd(key, values);

	}

	@Override
	public void add(String key, String... values) throws Exception {
		jedis.sadd(key, values);

	}

	@Override
	public void save(String key, int seconds, String... values) throws Exception {
		jedis.sadd(key, values);
		jedis.expire(key, seconds);
	}

	@Override
	public void add(String key, int seconds, String... values) throws Exception {
		jedis.sadd(key, values);
		jedis.expire(key, seconds);
	}

	@Override
	public int getArrSize(String key) throws Exception {
		Set<String> set = jedis.smembers(key);
		if (set == null) {
			return 0;
		}
		return set.size();
	}

	@Override
	public void delete(String key) throws Exception {
		jedis.del(key);

	}

	@Override
	public void setKeyPeriod(String key, int seconds) throws Exception {
		jedis.expire(key, seconds);
	}

}
