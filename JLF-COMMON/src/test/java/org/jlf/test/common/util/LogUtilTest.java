package org.jlf.test.common.util;

import org.jlf.common.util.LogUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: LogUtilTest
 * @Description:log工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class LogUtilTest {

	/**
	 * 
	 * @Title: get
	 * @Description:获取logger对象打印日志测试
	 */
	@Test
	public void get() {
		LogUtil.get().debug("wwwww");
	}

}
