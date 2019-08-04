package org.jlf.plugin.server.core.cache.redis;

import java.lang.reflect.Method;

import org.jlf.plugin.aop.user.api.JLFAopDo;

/**
 * 
 * @ClassName: RedisAopDo
 * @Description:RedisAop处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@SuppressWarnings("rawtypes")
public class RedisAopDo implements JLFAopDo {

	@Override
	public Object doBefore(Object obj, Method method, Object[] args) {
		RedisCore core = (RedisCore) obj;
		core.jedis = RedisPool.getJedis();
		return core;

	}

	@Override
	public Object doAfter(Object obj, Method method, Object[] args, Object bean) {
		RedisCore core = (RedisCore) obj;
		core.jedis.close();
		core.jedis = null;
		return core;

	}

	@Override
	public Object doException(Object obj, Method method, Object[] args, Object bean) {
		RedisCore core = (RedisCore) obj;
		if(core.jedis != null){
			core.jedis.close();
			core.jedis = null;
		}
		return core;

	}

}
