package org.jlf.test.common.util;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.enums.api.IEnum;
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
	 */
	@Test
	public void getById() {
		System.out.println(EnumUtil.getByID(BooleanType.class, 0));
		System.out.println(EnumUtil.getByID(BooleanType.class, 1));
	}

	/**
	 * 
	 * @Title: getByIdWithDefaultValue
	 * @Description:根据枚举id获取枚举对象,未获取到返回默认值
	 */
	@Test
	public void getByIdWithDefaultValue() {
		System.out.println(EnumUtil.getByID(BooleanType.class, 2, BooleanType.TRUE));
	}

	/**
	 * 
	 * @Title: getAllIds
	 * @Description:获取枚举的所有id数组测试
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
	 * @Description:获取枚举值数组测试
	 */
	@Test
	public void getAllValues() {
		IEnum[] arr = EnumUtil.getAllValues(BooleanType.class);
		for (IEnum e : arr) {
			System.out.println(e.getId() + e.getDesc());
		}
	}

}
