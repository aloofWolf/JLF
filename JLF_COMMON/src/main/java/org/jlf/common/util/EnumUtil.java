package org.jlf.common.util;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;

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
	 * @Description:����ö��id��ȡö�ٶ���,δ��ȡ������Ĭ��ֵ
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
