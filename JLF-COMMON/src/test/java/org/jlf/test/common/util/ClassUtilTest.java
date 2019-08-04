package org.jlf.test.common.util;

import org.jlf.common.util.ClassUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: ClassUtilTest
 * @Description:Class工具类测试
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class ClassUtilTest {

	/**
	 * 
	 * @Title: clsIsCustom
	 * @Description:判断class类是否是用户自定义类型
	 */
	@Test
	public <T> void clsIsCustom() {
		System.out.println(ClassUtil.clsIsCustom(String.class));
		System.out.println(ClassUtil.clsIsCustom(ChildC.class));
	}

}
