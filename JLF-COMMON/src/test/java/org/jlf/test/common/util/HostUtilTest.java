package org.jlf.test.common.util;

import org.jlf.common.util.HostUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: HostUtilTest
 * @Description:Host工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class HostUtilTest {

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:获取当前服务器ip测试
	 */
	@Test
	public void getCurrHostIp() {
		System.out.println(HostUtil.getCurrHostIp());
	}

}
