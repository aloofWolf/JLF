package org.jlf.soa.mvc.test.concurrent;

import org.jlf.common.util.concurrent.ConcurrentUtil;

/**
 * 
 * @ClassName: JLFMVCConcurrentTest
 * @Description:����MVC��ܲ�������
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCConcurrentTest {

	/**
	 * 
	 * @Title: main
	 * @Description:����MVC��ܲ�������
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentUtil.concurrent(1, new JLFMVCConcurrentOperator());
	}

}
