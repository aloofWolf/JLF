package org.jlf.plugin.server.core.cache.redisCluster;

import java.io.Serializable;
import java.util.Set;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.cache.server.api.JLFCache;

/**
 * 
 * @ClassName: RedisClusterCore
 * @Description:RedisClusterCore
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class RedisClusterCore implements JLFCache {

	@Override
	public void save(String key, String value) {
		RedisClusterPool.getJedis().set(key, value);
	}

	@Override
	public void save(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().set(key, ser);

	}

	@Override
	public void save(String key, String value, int seconds) {
		RedisClusterPool.getJedis().set(key, value);
		RedisClusterPool.getJedis().expire(key, seconds);

	}

	@Override
	public void save(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().set(key, ser);
		RedisClusterPool.getJedis().expire(key, seconds);
	}

	@Override
	public void update(String key, String value) {
		RedisClusterPool.getJedis().set(key, value);
	}

	@Override
	public void update(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().set(key, ser);

	}

	@Override
	public void update(String key, String value, int seconds) {
		RedisClusterPool.getJedis().set(key, value);
		RedisClusterPool.getJedis().expire(key, seconds);

	}

	@Override
	public void update(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().set(key, ser);
		RedisClusterPool.getJedis().expire(key, seconds);

	}

	@Override
	public String getString(String key) {
		return RedisClusterPool.getJedis().get(key);
	}

	@Override
	public <T extends Serializable> T getObj(String key, Class<T> cls) {
		String ser = RedisClusterPool.getJedis().get(key);
		if (ser == null) {
			return null;
		}
		T t = SerializeUtil.serializeToObject(ser);
		return t;
	}

	@Override
	public void save(String key, String... values) {
		RedisClusterPool.getJedis().sadd(key, values);

	}

	@Override
	public void add(String key, String... values) {
		RedisClusterPool.getJedis().sadd(key, values);

	}

	@Override
	public void save(String key, int seconds, String... values) {
		RedisClusterPool.getJedis().sadd(key, values);
		RedisClusterPool.getJedis().expire(key, seconds);
	}

	@Override
	public void add(String key, int seconds, String... values) {
		RedisClusterPool.getJedis().sadd(key, values);
		RedisClusterPool.getJedis().expire(key, seconds);
	}

	@Override
	public int getArrSize(String key) {
		Set<String> set = RedisClusterPool.getJedis().smembers(key);
		if (set == null) {
			return 0;
		}
		return set.size();
	}

	@Override
	public void delete(String key) {
		RedisClusterPool.getJedis().del(key);

	}

	@Override
	public void setKeyPeriod(String key, int seconds) {
		RedisClusterPool.getJedis().expire(key, seconds);
	}

}
