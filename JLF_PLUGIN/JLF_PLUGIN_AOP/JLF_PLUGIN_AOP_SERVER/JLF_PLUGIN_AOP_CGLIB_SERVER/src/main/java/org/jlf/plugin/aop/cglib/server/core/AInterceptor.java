package org.jlf.plugin.aop.cglib.server.core;

import java.lang.reflect.Method;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.aop.user.api.JLFAopDo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @ClassName: AInterceptor
 * @Description:MethodInterceptor����չʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 * @param <T>
 */
public class AInterceptor<T> implements MethodInterceptor {

	private JLFAopDo<T> aopDo;

	public AInterceptor(JLFAopDo<T> aopDo) {
		this.aopDo = aopDo;
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
	public T doBefore(Object obj, Method method, Object[] args, MethodProxy proxy) {
		return this.aopDo.doBefore(obj, method, args);
	}

	/**
	 * @Title: doAfter
	 * @Description:�º���
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 */
	public T doAfter(Object obj, Method method, Object[] args, MethodProxy proxy, T t) {
		return this.aopDo.doAfter(obj, method, args, t);
	}

	/**
	 * @Title: doException
	 * @Description:�쳣����
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 */
	public T doException(Object obj, Method method, Object[] args, MethodProxy proxy, T t) {
		return this.aopDo.doException(obj, method, args, t);
	}

	/**
	 * �ص�����
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) {
		return proxyIntercept(obj, method, args, proxy);
	}

	/**
	 * @Title: proxyIntercept
	 * @Description:����ص�����
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 * @return
	 */
	private Object proxyIntercept(Object obj, Method method, Object[] args, MethodProxy proxy) {
		T t = null;
		Object resp = null;
		try {
			t = doBefore(obj, method, args, proxy);
			resp = proxy.invokeSuper(obj, args);
			doAfter(obj, method, args, proxy, t);
		} catch (Throwable e) {
			e.printStackTrace();
			doException(obj, method, args, proxy, t);
			throw new JLFException(e);
		}
		return resp;
	}

}
