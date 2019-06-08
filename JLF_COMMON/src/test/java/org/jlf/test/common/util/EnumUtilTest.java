package org.jlf.test.common.util;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.util.EnumUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: EnumUtilTest
 * @Description:枚举工具类测试
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class EnumUtilTest {

	/**
	 * 
	 * @Title: getById
	 * @Description:根据枚举id获取枚举对象测试
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
	 * @Description:根据枚举id获取枚举对象,未获取到返回默认值
	 * @throws Exception
	 */
	@Test
	public void getByIdWithDefaultValue() throws Exception {
		System.out.println(EnumUtil.getByID(BooleanType.class, 2, BooleanType.TRUE));
	}

}
