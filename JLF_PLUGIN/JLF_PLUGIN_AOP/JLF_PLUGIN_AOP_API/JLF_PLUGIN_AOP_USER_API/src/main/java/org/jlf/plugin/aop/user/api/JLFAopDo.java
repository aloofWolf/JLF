package org.jlf.plugin.aop.user.api;

import java.lang.reflect.Method;

/**
 * 
 * @ClassName: JLFAopDo
 * @Description:Aop����ģʽapi,����Ҫ�������ʵ��,����������ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 * @param <T>
 */
public interface JLFAopDo<T> {

	/**
	 * 
	 * @Title: doBefore
	 * @Description:��ǰ����
	 * @param obj
	 * @param method
	 * @param args
	 */
	public T doBefore(Object obj, Method method, Object[] args);

	/**
	 * 
	 * @Title: doAfter
	 * @Description:�º���
	 * @param obj
	 * @param method
	 * @param args
	 */
	public T doAfter(Object obj, Method method, Object[] args, T t);

	/**
	 * 
	 * @Title: doException
	 * @Description:�쳣����
	 * @param obj
	 * @param method
	 * @param args
	 */
	public T doException(Object obj, Method method, Object[] args, T t);

}
