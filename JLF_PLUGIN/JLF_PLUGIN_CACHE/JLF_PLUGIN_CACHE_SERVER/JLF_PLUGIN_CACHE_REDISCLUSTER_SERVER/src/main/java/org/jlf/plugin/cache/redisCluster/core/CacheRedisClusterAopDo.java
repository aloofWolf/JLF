package org.jlf.plugin.cache.redisCluster.core;

import java.lang.reflect.Method;

import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: CacheRedisClusterAopDo
 * @Description:CacheRedisClusterAop处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@SuppressWarnings("rawtypes")
public class CacheRedisClusterAopDo implements JLFAopDo {

	@Override
	public Object doBefore(Object obj, Method method, Object[] args) {
		CacheRedisClusterCore core = (CacheRedisClusterCore) obj;
		core.jedis = CacheRedisClusterPool.getJedis();
		return core;

	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object bean) {
		CacheRedisClusterCore core = (CacheRedisClusterCore) obj;
		core.jedis = null;
		return core;

	}

	@Override
	public Object doException(Object obj, Method method, Object[] args, Object bean) {
		CacheRedisClusterCore core = (CacheRedisClusterCore) obj;
		core.jedis = null;
		return core;

	}

}
