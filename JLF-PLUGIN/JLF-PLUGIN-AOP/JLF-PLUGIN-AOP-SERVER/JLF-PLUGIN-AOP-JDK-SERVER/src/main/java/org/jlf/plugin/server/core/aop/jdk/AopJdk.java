package org.jlf.plugin.server.core.aop.jdk;

import java.lang.reflect.Proxy;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.aop.user.api.JLFAopDo;

public class AopJdk implements JLFAop {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> T getProxy(Class<T> tCls, JLFAopDo<?> aopDo) {
		AInvocationHandler<?> interceptor;
		try {
			interceptor = new AInvocationHandler(aopDo,tCls.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException("创建对象失败:"+tCls.getSimpleName());
		}
		T t = (T) Proxy.newProxyInstance(tCls.getClassLoader(),tCls.getInterfaces(), interceptor);
		return t;
	}

}

