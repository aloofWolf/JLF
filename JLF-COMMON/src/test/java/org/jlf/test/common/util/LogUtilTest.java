package org.jlf.test.common.util;

import org.jlf.common.util.LogUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: LogUtilTest
 * @Description:log���������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class LogUtilTest {

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡlogger�����ӡ��־����
	 */
	@Test
	public void get() {
		LogUtil.get().debug("wwwww");
	}

}
