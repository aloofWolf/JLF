package org.jlf.common.util;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;

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
	 * @throws Exception
	 */
	public static <E extends IEnum> E getByID(Class<E> cls, Integer id) throws Exception {
		E[] arr = cls.getEnumConstants();
		for (E e : arr) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		throw new Exception(String.format(E.idNoExistExceptionMessage, "ExpressOperatorType", id));
	}

	/**
	 * 
	 * @Title: getByID
	 * @Description:根据枚举id获取枚举对象,未获取到返回默认值
	 * @param cls
	 * @param id
	 * @param defaultValue
	 * @return
	 * @throws Exception
	 */
	public static <E extends IEnum> E getByID(Class<E> cls, Integer id, E defaultValue) throws Exception {
		E[] arr = cls.getEnumConstants();
		for (E e : arr) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return defaultValue;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getByID(BooleanType.class, 0));
		System.out.println(getByID(BooleanType.class, 1));
		System.out.println(getByID(BooleanType.class, 2));
	}

}
