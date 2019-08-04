package org.jlf.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: SingletonUtil
 * @Description:单例工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class SingletonUtil {

	private static final Map<Class<?>, Object> defaultSingleObjMap = new HashMap<Class<?>, Object>();

	/**
	 * 
	 * @Title: getInstance
	 * @Description:根据默认的singleObjMap获取单例对象
	 * @param cls
	 * @return
	 */
	public static <T> T getInstance(Class<T> cls) {
		return getInstance(cls, defaultSingleObjMap);
	}

	/**
	 * 
	 * @Title: getInstance
	 * @Description:根据指定的singleObjMap获取单例对象
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
	 * @Description:向map中赋值
	 * @param cls
	 * @param t
	 */
	public static <T> void put(Class<T> cls, T t) {
		defaultSingleObjMap.put(cls, t);
	}

}
