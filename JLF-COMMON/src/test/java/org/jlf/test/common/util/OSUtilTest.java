package org.jlf.test.common.util;

import org.jlf.common.util.OSUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: OSUtilTest
 * @Description:����ϵͳ���������
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class OSUtilTest {

	/**
	 * 
	 * @Title: getLineSeparatorTest
	 * @Description:��ȡ�зָ���
	 */
	@Test
	public void getLineSeparatorTest() {
		System.out.println(OSUtil.getLineSeparator());
	}

	/**
	 * 
	 * @Title: getPathSeparatorTest
	 * @Description:��ȡ�ļ�·���ָ���
	 */
	@Test
	public void getPathSeparatorTest() {
		System.out.println(OSUtil.getPathSeparator());
	}

}
