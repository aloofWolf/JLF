package org.jlf.test.common.util.sort;

import org.jlf.common.util.sort.SortBubbleUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SortBubbleUtilTest
 * @Description:冒泡排序工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortBubbleUtilTest {

	/**
	 * 
	 * @Title: sort
	 * @Description:冒泡排序算法,未指定排序规则
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
	 * @Description:冒泡排序算法,指定排序规则
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
