package org.jlf.plugin.cache.redis.core;

import java.lang.reflect.Method;

import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: JLFMVCServiceAopDo
 * @Description:CacheRedisAop处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@SuppressWarnings("rawtypes")
public class CacheRedisAopDo implements JLFAopDo {


	@Override
	public Object doBefore(Object obj, Method method, Object[] args) throws Exception {
		CacheRedisCore core = (CacheRedisCore) obj;
		core.jedis = CacheRedisPool.getJedis();
		return core;

	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object bean) throws Exception {
		CacheRedisCore core = (CacheRedisCore) obj;
		core.jedis.close();
		core.jedis = null;
		return core;

	}

	@Override
	public Object doException(Object obj, Method method, Object[] args, Object bean) throws Exception {
		CacheRedisCore core = (CacheRedisCore) obj;
		core.jedis.close();
		core.jedis = null;
		return core;

	}

}
