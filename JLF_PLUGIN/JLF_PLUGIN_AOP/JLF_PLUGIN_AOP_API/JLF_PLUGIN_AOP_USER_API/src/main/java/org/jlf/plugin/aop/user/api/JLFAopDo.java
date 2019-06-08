package org.jlf.plugin.aop.user.api;

import java.lang.reflect.Method;

/**
 * 
 * @ClassName: JAFAopDo
 * @Description:Aop处理模式api,不需要具体服务实现,需具体调用者实现
 * @author Lone Wolf
 * @date 2019年5月22日
 * @param <T>
 */
public interface JLFAopDo<T> {

	/**
	 * 
	 * @Title: doBefore
	 * @Description:事前处理
	 * @param obj
	 * @param method
	 * @param args
	 * @throws Exception
	 */
	public T doBefore(Object obj, Method method, Object[] args) throws Exception;

	/**
	 * 
	 * @Title: doAfter
	 * @Description:事后处理
	 * @param obj
	 * @param method
	 * @param args
	 * @throws Exception
	 */
	public T doAfter(Object obj, Method method, Object[] args, T t) throws Exception;

	/**
	 * 
	 * @Title: doException
	 * @Description:异常处理
	 * @param obj
	 * @param method
	 * @param args
	 * @throws Exception
	 */
	public T doException(Object obj, Method method, Object[] args, T t) throws Exception;

}
