package org.jlf.soa.mvc.test.concurrent;

import org.jlf.common.util.concurrent.ConcurrentUtil;

/**
 * 
 * @ClassName: JLFMVCConcurrentTest
 * @Description:测试MVC框架并发操作
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCConcurrentTest {

	/**
	 * 
	 * @Title: main
	 * @Description:测试MVC框架并发操作
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentUtil.concurrent(1, new JLFMVCConcurrentOperator());
	}

}
