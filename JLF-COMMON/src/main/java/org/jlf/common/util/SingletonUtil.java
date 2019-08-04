package org.jlf.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: SingletonUtil
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class SingletonUtil {

	private static final Map<Class<?>, Object> defaultSingleObjMap = new HashMap<Class<?>, Object>();

	/**
	 * 
	 * @Title: getInstance
	 * @Description:����Ĭ�ϵ�singleObjMap��ȡ��������
	 * @param cls
	 * @return
	 */
	public static <T> T getInstance(Class<T> cls) {
		return getInstance(cls, defaultSingleObjMap);
	}

	/**
	 * 
	 * @Title: getInstance
	 * @Description:����ָ����singleObjMap��ȡ��������
	 * @param cls
	 * @param singleObjMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> cls, final Map<Class<?>, ?> singleObjMap) {
		Object obj = defaultSingleObjMap.get(cls);
		if (obj == null) {
			try {
				obj = cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			defaultSingleObjMap.put(cls, obj);
		}
		return (T) obj;
	}

	/**
	 * 
	 * @Title: put
	 * @Description:��map�и�ֵ
	 * @param cls
	 * @param t
	 */
	public static <T> void put(Class<T> cls, T t) {
		defaultSingleObjMap.put(cls, t);
	}

}
