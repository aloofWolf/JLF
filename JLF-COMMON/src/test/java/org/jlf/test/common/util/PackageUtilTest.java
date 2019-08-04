package org.jlf.test.common.util;

import java.util.List;

import org.jlf.common.util.PackageUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: PackageUtilTest
 * @Description:package�����������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class PackageUtilTest {

	/**
	 * 
	 * @Title: getClss
	 * @Description:��ȡ�������������
	 */
	@Test
	public void getClss() {
		List<Class<?>> clsNames = PackageUtil.getPackageClss("/");
		for (Class<?> cls : clsNames) {
			System.out.println(cls.getName());
		}
	}
}
