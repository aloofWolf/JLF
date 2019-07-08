package org.jlf.plugin.aop.cglib.server.core;

import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.aop.user.api.JLFAopDo;

import net.sf.cglib.proxy.Enhancer;

/**
 * 
 * @ClassName: AopCglib
 * @Description:AopCglib�ľ���ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class AopCglib implements JLFAop {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> T getProxy(Class<T> tCls, JLFAopDo<?> aopDo) {
		Enhancer enhancer = new Enhancer();
		AInterceptor<?> interceptor = new AInterceptor(aopDo);
		enhancer.setSuperclass(tCls);
		enhancer.setCallback(interceptor);
		enhancer.setClassLoader(ClassLoaderUtil.getLoader());
		return (T) enhancer.create();
	}

}
