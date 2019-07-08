package org.jlf.common.util;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.exception.JLFException;

/**
 * 
 * @ClassName: EnumUtil
 * @Description:ö�ٹ�����
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class EnumUtil {

	/**
	 * 
	 * @Title: getByID
	 * @Description:����ö��id��ȡö�ٶ���
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
	 * @Description:����ö��id��ȡö�ٶ���,δ��ȡ������Ĭ��ֵ
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
	 * @Description:��ȡö�ٵ�����id����
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
	 * @Description:��ȡö��ֵ����
	 * @param cls
	 * @return
	 */
	public static <E extends IEnum> E[] getAllValues(Class<E> cls) {
		return cls.getEnumConstants();
	}
}
