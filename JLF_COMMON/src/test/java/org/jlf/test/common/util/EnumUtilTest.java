package org.jlf.test.common.util;

import org.jlf.common.enums.BooleanType;
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
	 * @throws Exception
	 */
	@Test
	public void getById() throws Exception {
		System.out.println(EnumUtil.getByID(BooleanType.class, 0));
		System.out.println(EnumUtil.getByID(BooleanType.class, 1));
	}

	/**
	 * 
	 * @Title: getByIdWithDefaultValue
	 * @Description:����ö��id��ȡö�ٶ���,δ��ȡ������Ĭ��ֵ
	 * @throws Exception
	 */
	@Test
	public void getByIdWithDefaultValue() throws Exception {
		System.out.println(EnumUtil.getByID(BooleanType.class, 2, BooleanType.TRUE));
	}

}
