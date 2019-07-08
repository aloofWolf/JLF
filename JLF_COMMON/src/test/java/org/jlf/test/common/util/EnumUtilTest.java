package org.jlf.test.common.util;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: EnumUtilTest
 * @Description:ö�ٹ��������
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class EnumUtilTest {

	/**
	 * 
	 * @Title: getById
	 * @Description:����ö��id��ȡö�ٶ������
	 */
	@Test
	public void getById() {
		System.out.println(EnumUtil.getByID(BooleanType.class, 0));
		System.out.println(EnumUtil.getByID(BooleanType.class, 1));
	}

	/**
	 * 
	 * @Title: getByIdWithDefaultValue
	 * @Description:����ö��id��ȡö�ٶ���,δ��ȡ������Ĭ��ֵ
	 */
	@Test
	public void getByIdWithDefaultValue() {
		System.out.println(EnumUtil.getByID(BooleanType.class, 2, BooleanType.TRUE));
	}

	/**
	 * 
	 * @Title: getAllIds
	 * @Description:��ȡö�ٵ�����id�������
	 */
	@Test
	public void getAllIds() {
		Integer[] arr = EnumUtil.getAllIds(BooleanType.class);
		for (Integer i : arr) {
			System.out.println(i);
		}
	}

	/**
	 * 
	 * @Title: getAllValues
	 * @Description:��ȡö��ֵ�������
	 */
	@Test
	public void getAllValues() {
		IEnum[] arr = EnumUtil.getAllValues(BooleanType.class);
		for (IEnum e : arr) {
			System.out.println(e.getId() + e.getDesc());
		}
	}

}
