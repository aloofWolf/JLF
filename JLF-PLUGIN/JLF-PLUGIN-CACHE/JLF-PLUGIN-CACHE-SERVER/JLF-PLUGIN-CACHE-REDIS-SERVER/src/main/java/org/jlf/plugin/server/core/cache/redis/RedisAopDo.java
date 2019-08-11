package org.jlf.plugin.server.core.cache.redis;

import java.lang.reflect.Method;

import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: RedisAopDo
 * @Description:RedisAop����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
@SuppressWarnings("rawtypes")
public class RedisAopDo implements JLFAopDo {

	@Override
	public Object doBefore(Object obj, Method method, Object[] args) {
		RedisCore core = (RedisCore) obj;
		core.jedis.set(RedisPool.getJedis());
		return core;

	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object bean) {
		RedisCore core = (RedisCore) obj;
		core.jedis.get().close();
		core.jedis.remove();
		return core;

	}

	@Override
	public Object doException(Object obj, Method method, Object[] args, Object bean) {
		RedisCore core = (RedisCore) obj;
		if(core.jedis.get() != null){
			core.jedis.get().close();
			core.jedis.remove();
		}
		return core;

	}

}
