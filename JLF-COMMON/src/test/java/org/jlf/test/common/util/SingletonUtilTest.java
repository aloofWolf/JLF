package org.jlf.test.common.util;

import org.jlf.common.util.LogUtil;
import org.jlf.common.util.SingletonUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SingletonUtilTest
 * @Description:单例工具类测试
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class SingletonUtilTest {

	public SingletonUtilTest() {
		new SingletonUtilTest();
	}

	/**
	 * 
	 * @Title: noSingle
	 * @Description:不用单例模式构造对象测试
	 */
	@Test
	public void noSingle() {
		long before = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			SingletonUtilTest t = new SingletonUtilTest();
			LogUtil.get().info("" + t.hashCode());
		}
		long after = System.currentTimeMillis();
		System.out.println("创建对象花费毫秒数:" + (after - before));// 81134
	}

	/**
	 * 
	 * @throws InterruptedException
	 * @Title: single
	 * @Description:采用单例模式构造对称测试
	 * @throws Exception
	 */
	@Test
	public void single() throws InterruptedException {
		long before = System.currentTimeMillis();
		SingletonUtil.put(SingletonUtilTest.class, new SingletonUtilTest());
		for (int i = 0; i < 10000000; i++) {
			SingletonUtilTest t = SingletonUtil.getInstance(SingletonUtilTest.class);
			LogUtil.get().info("" + t.hashCode());
		}
		long after = System.currentTimeMillis();
		System.out.println("创建对象花费毫秒数:" + (after - before));// 89696
	}

}
