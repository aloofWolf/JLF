package org.jlf.common.util;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.exception.JLFException;

/**
 * 
 * @ClassName: EnumUtil
 * @Description:枚举工具类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class EnumUtil {

	/**
	 * 
	 * @Title: getByID
	 * @Description:根据枚举id获取枚举对象
	 * @param cls
	 * @param id
	 * @return
	 */
	public static <E extends IEnum> E getByID(Class<E> cls, Integer id) {
		E[] arr = cls.getEnumConstants();
		for (E e : arr) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		throw new JLFException(String.format(E.idNoExistExceptionMessage, "ExpressOperatorType", id));
	}

	/**
	 * 
	 * @Title: getByID
	 * @Description:根据枚举id获取枚举对象,未获取到返回默认值
	 * @param cls
	 * @param id
	 * @param defaultValue
	 * @return
	 */
	public static <E extends IEnum> E getByID(Class<E> cls, Integer id, E defaultValue) {
		E[] arr = cls.getEnumConstants();
		for (E e : arr) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return defaultValue;
	}

	/**
	 * 
	 * @Title: getAllIds
	 * @Description:获取枚举的所有id数组
	 * @param cls
	 * @return
	 */
	public static <E extends IEnum> Integer[] getAllIds(Class<E> cls) {
		E[] values = cls.getEnumConstants();
		Integer[] arr = new Integer[values.length];
		for (int i = 0; i < values.length; i++) {
			arr[i] = values[i].getId();
		}
		return arr;

	}

	/**
	 * 
	 * @Title: getAllValues
	 * @Description:获取枚举值数组
	 * @param cls
	 * @return
	 */
	public static <E extends IEnum> E[] getAllValues(Class<E> cls) {
		return cls.getEnumConstants();
	}
}
