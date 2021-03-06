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
 * @date 2019��5��31��
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
		RedisClusterPool.getJedis().setex(key, seconds,value);
	}

	@Override
	public void save(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().setex(key,seconds, ser);
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
		RedisClusterPool.getJedis().setex(key, seconds,value);

	}

	@Override
	public void update(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		RedisClusterPool.getJedis().setex(key, seconds,ser);

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
	public void remove(String key, String... values) {
		RedisClusterPool.getJedis().srem(key, values);
		
	}

	@Override
	public String getRandom(String key) {
		return RedisClusterPool.getJedis().srandmember(key);
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
	public Set<String> getSet(String key) {
		return RedisClusterPool.getJedis().smembers(key);
	}

	@Override
	public void delete(String key) {
		RedisClusterPool.getJedis().del(key);

	}

	@Override
	public void setKeyPeriod(String key, int seconds) {
		RedisClusterPool.getJedis().expire(key, seconds);
	}

	@Override
	public boolean setnx(String key, String value) {
		long flg = RedisClusterPool.getJedis().setnx(key, value);
		if (flg == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean setnx(String key, String value,int seconds) {
		String flg = RedisClusterPool.getJedis().set(key, value, "nx", "ex", seconds);
		if ("OK".equals(flg)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean setnx(String key, Serializable bean) {
		String ser = SerializeUtil.serialize(bean);
		return setnx(key,ser);
	}

	@Override
	public boolean setnx(String key, Serializable bean, int seconds) {
		String ser = SerializeUtil.serialize(bean);
		return setnx(key,ser,seconds);
	}
	
	@Override
	public boolean exists(String key) {
		return RedisClusterPool.getJedis().exists(key);
	}

}
