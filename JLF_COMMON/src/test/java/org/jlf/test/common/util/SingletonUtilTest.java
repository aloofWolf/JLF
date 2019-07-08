package org.jlf.test.common.util;

import org.jlf.common.util.SingletonUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SingletonUtilTest
 * @Description:�������������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class SingletonUtilTest {

	/**
	 * 
	 * @Title: noSingle
	 * @Description:���õ���ģʽ����������
	 */
	@Test
	public void noSingle() {
		long before = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			SingletonUtilTest t = new SingletonUtilTest();
			System.out.println(t.hashCode());
		}
		long after = System.currentTimeMillis();
		System.out.println("�������󻨷Ѻ�����:" + (after - before));// 81134
	}

	/**
	 * 
	 * @Title: single
	 * @Description:���õ���ģʽ����ԳƲ���
	 * @throws Exception
	 */
	@Test
	public void single() {
		long before = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			SingletonUtilTest t = SingletonUtil.getInstance(SingletonUtilTest.class);
			System.out.println(t.hashCode());
		}
		long after = System.currentTimeMillis();
		System.out.println("�������󻨷Ѻ�����:" + (after - before));// 89696
	}

}
