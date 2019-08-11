package org.jlf.test.common.util;

import java.util.List;

import org.jlf.common.util.PackageUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: PackageUtilTest
 * @Description:package工具类测试类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class PackageUtilTest {

	/**
	 * 
	 * @Title: getClss
	 * @Description:获取包下所有类测试
	 */
	@Test
	public void getClss() {
		List<Class<?>> clsNames = PackageUtil.getPackageClss("org.jlf");
		for (Class<?> cls : clsNames) {
			System.out.println(cls.getName());
		}
	}

	/**
	 * 
	 * @Title: getPackageName
	 * @Description:根据cls获取packageName测试
	 */
	@Test
	public void getPackageName() {
		System.out.println(PackageUtil.getPackageName(PackageUtilTest.class));
	}
}
