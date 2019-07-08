package org.jlf.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * 
 * @ClassName: GenericityUtil
 * @Description:���͹�����
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class GenericityUtil {

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:��ȡ��Ա�����ֶ��еĵ�һ������������class
	 * @param field
	 * @return
	 */
	public static <T> Class<T> getFieldGenerCls(Field field) {
		return getFieldGenerCls(field, 1);
	}

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:��ȡ��Ա�����ֶ��е�indexλ�õķ���������class
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
	 * @Description:��ȡ��ǰ����ĵ�һ������������class
	 * @param obj
	 * @return
	 */
	public static <T> Class<T> getObjGenerCls(Class<?> obj) {
		return getObjGenerCls(obj, 1);
	}

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:��ȡ��ǰ�����indexλ�õķ���������class
	 * @param obj
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getObjGenerCls(Class<?> obj, int index) {
		return (Class<T>) ((ParameterizedType) obj.getGenericSuperclass()).getActualTypeArguments()[index - 1];
	}
}
