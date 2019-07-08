package org.jlf.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * 
 * @ClassName: GenericityUtil
 * @Description:泛型工具类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class GenericityUtil {

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取成员变量字段中的第一个泛型所属的class
	 * @param field
	 * @return
	 */
	public static <T> Class<T> getFieldGenerCls(Field field) {
		return getFieldGenerCls(field, 1);
	}

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取成员变量字段中的index位置的泛型所属的class
	 * @param field
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getFieldGenerCls(Field field, int index) {
		return (Class<T>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[index - 1];
	}

	/**
	 * 
	 * @Title: getTClass
	 * @Description:获取当前对象的第一个泛型所属的class
	 * @param obj
	 * @return
	 */
	public static <T> Class<T> getObjGenerCls(Class<?> obj) {
		return getObjGenerCls(obj, 1);
	}

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:获取当前对象的index位置的泛型所属的class
	 * @param obj
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getObjGenerCls(Class<?> obj, int index) {
		return (Class<T>) ((ParameterizedType) obj.getGenericSuperclass()).getActualTypeArguments()[index - 1];
	}
}
