package org.jlf.plugin.server.core.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.aop.user.api.JLFAopDo;

public class AInvocationHandler<T> implements InvocationHandler{
	
	private JLFAopDo<T> aopDo;
	private Object source;

	public AInvocationHandler(JLFAopDo<T> aopDo,Object source) {
		this.aopDo = aopDo;
		this.source = source;
	}
	
	/**
	 * 
	 * @Title: doBefore
	 * @Description:
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 */
	public T doBefore(Object obj, Method method, Object[] args) {
		return this.aopDo.doBefore(obj, method, args);
	}

	/**
	 * @Title: doAfter
	 * @Description:事后处理
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 */
	public T doAfter(Object obj, Method method, Object[] args,  T t) {
		return this.aopDo.doAfter(obj, method, args, t);
	}

	/**
	 * @Title: doException
	 * @Description:异常处理
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 */
	public T doException(Object obj, Method method, Object[] args,  T t) {
		return this.aopDo.doException(obj, method, args, t);
	}

	/**
	 * 回调函数
	 */
	@Override
	public Object invoke(Object obj, Method method, Object[] args) {
		return proxyIntercept(obj, method, args);
	}

	/**
	 * @Title: proxyIntercept
	 * @Description:代理回调函数
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 * @return
	 */
	private Object proxyIntercept(Object obj, Method method, Object[] args) {
		T t = null;
		Object resp = null;
		try {
			t = doBefore(obj, method, args);
			resp = method.invoke(source, args);
			doAfter(obj, method, args, t);
		} catch (Throwable e) {
			e.printStackTrace();
			doException(obj, method, args, t);
			throw new JLFException(e);
		}
		return resp;
	}


}
