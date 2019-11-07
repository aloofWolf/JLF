package org.jlf.plugin.server.core.cache.redis;

import java.io.Serializable;
import java.util.Set;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.cache.server.api.JLFCache;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName: RedisCore
 * @Description:RedisCore
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class RedisCore implements JLFCache {

	protected ThreadLocal<Jedis> jedis = new ThreadLocal<Jedis>();

	@Override
	public void save(String key, String value) {
		jedis.get().set(key, value);
	}

	@Override
	public void save(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		jedis.get().set(key, ser);

	}

	@Override
	public void save(String key, String value, int seconds) {
		jedis.get().setex(key, seconds, value);

	}

	@Override
	public void save(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		jedis.get().setex(key,seconds, ser);
	}

	@Override
	public void update(String key, String value) {
		jedis.get().set(key, value);
	}

	@Override
	public void update(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		jedis.get().set(key, ser);

	}

	@Override
	public void update(String key, String value, int seconds) {
		jedis.get().setex(key, seconds,value);

	}

	@Override
	public void update(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		jedis.get().setex(key, seconds,ser);

	}

	@Override
	public String getString(String key) {
		return jedis.get().get(key);
	}

	@Override
	public <T extends Serializable> T getObj(String key, Class<T> cls) {
		String ser = jedis.get().get(key);
		if (ser == null) {
			return null;
		}
		T t = SerializeUtil.serializeToObject(ser);
		return t;
	}

	@Override
	public void save(String key, String... values) {
		jedis.get().sadd(key, values);

	}

	@Override
	public void add(String key, String... values) {
		jedis.get().sadd(key, values);

	}

	@Override
	public void save(String key, int seconds, String... values) {
		jedis.get().sadd(key, values);
		jedis.get().expire(key, seconds);
	}

	@Override
	public void add(String key, int seconds, String... values) {
		jedis.get().sadd(key, values);
		jedis.get().expire(key, seconds);
	}

	@Override
	public void remove(String key, String... values) {
		jedis.get().srem(key, values);

	}

	@Override
	public String getRandom(String key) {
		return jedis.get().srandmember(key);
	}

	@Override
	public int getArrSize(String key) {
		Set<String> set = jedis.get().smembers(key);
		if (set == null) {
			return 0;
		}
		return set.size();
	}

	@Override
	public Set<String> getSet(String key) {
		return jedis.get().smembers(key);
	}

	@Override
	public void delete(String key) {
		jedis.get().del(key);

	}

	@Override
	public void setKeyPeriod(String key, int seconds) {
		jedis.get().expire(key, seconds);
	}

	@Override
	public boolean setnx(String key, String value) {
		long flg = jedis.get().setnx(key, value);
		if (flg == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean setnx(String key, String value,int seconds) {
		String flg = jedis.get().set(key, value, "nx", "ex", seconds);
		if ("OK".equals(flg)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean exists(String key) {
		return jedis.get().exists(key);
	}

}
