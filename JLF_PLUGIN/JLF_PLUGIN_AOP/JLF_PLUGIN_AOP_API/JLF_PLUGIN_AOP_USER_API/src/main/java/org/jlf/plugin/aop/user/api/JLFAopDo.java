package org.jlf.plugin.aop.user.api;

import java.lang.reflect.Method;

/**
 * 
 * @ClassName: JAFAopDo
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
	 * @throws Exception
	 */
	public T doBefore(Object obj, Method method, Object[] args) throws Exception;

	/**
	 * 
	 * @Title: doAfter
	 * @Description:�º���
	 * @param obj
	 * @param method
	 * @param args
	 * @throws Exception
	 */
	public T doAfter(Object obj, Method method, Object[] args, T t) throws Exception;

	/**
	 * 
	 * @Title: doException
	 * @Description:�쳣����
	 * @param obj
	 * @param method
	 * @param args
	 * @throws Exception
	 */
	public T doException(Object obj, Method method, Object[] args, T t) throws Exception;

}
