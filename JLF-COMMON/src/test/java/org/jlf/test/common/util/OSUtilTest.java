package org.jlf.test.common.util;

import org.jlf.common.util.OSUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: OSUtilTest
 * @Description:操作系统工具类测试
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class OSUtilTest {

	/**
	 * 
	 * @Title: getLineSeparatorTest
	 * @Description:获取行分隔符
	 */
	@Test
	public void getLineSeparatorTest() {
		System.out.println(OSUtil.getLineSeparator());
	}

	/**
	 * 
	 * @Title: getPathSeparatorTest
	 * @Description:获取文件路径分隔符
	 */
	@Test
	public void getPathSeparatorTest() {
		System.out.println(OSUtil.getPathSeparator());
	}

}
