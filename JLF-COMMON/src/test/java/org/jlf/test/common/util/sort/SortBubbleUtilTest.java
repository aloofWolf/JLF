package org.jlf.test.common.util.sort;

import org.jlf.common.util.sort.SortBubbleUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SortBubbleUtilTest
 * @Description:ð�����򹤾������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortBubbleUtilTest {

	/**
	 * 
	 * @Title: sort
	 * @Description:ð�������㷨,δָ���������
	 */
	@Test
	public <T extends Object> void sort() {
		Integer[] array = { 4, 6, 32, 65, 11, 33, 100, 1 };
		array = SortBubbleUtil.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 
	 * @Title: sortWithRule
	 * @Description:ð�������㷨,ָ���������
	 */
	@Test
	public <T extends Object> void sortWithRule() {
		Integer[] array = { 4, 6, 32, 65, 11, 33, 100, 1 };
		array = SortBubbleUtil.sort(array, new SortRuleIntegerTest());
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
