package org.jlf.test.common.util;

import org.jlf.common.util.HostUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: HostUtilTest
 * @Description:Host���������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class HostUtilTest {

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:��ȡ��ǰ������ip����
	 */
	@Test
	public void getCurrHostIp() {
		System.out.println(HostUtil.getCurrHostIp());
	}

}
