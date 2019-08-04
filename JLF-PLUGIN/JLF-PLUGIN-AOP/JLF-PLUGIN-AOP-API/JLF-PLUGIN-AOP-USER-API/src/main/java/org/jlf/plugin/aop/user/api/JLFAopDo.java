package org.jlf.plugin.aop.user.api;

import java.lang.reflect.Method;

/**
 * 
 * @ClassName: JLFAopDo
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
	 */
	public T doBefore(Object obj, Method method, Object[] args);

	/**
	 * 
	 * @Title: doAfter
	 * @Description:事后处理
	 * @param obj
	 * @param method
	 * @param args
	 */
	public T doAfter(Object obj, Method method, Object[] args, T t);

	/**
	 * 
	 * @Title: doException
	 * @Description:异常处理
	 * @param obj
	 * @param method
	 * @param args
	 */
	public T doException(Object obj, Method method, Object[] args, T t);

}
