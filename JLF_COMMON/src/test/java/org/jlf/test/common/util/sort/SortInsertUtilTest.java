package org.jlf.test.common.util.sort;

import org.jlf.common.util.sort.SortInsertUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SortInsertUtilTest
 * @Description:插入排序工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortInsertUtilTest {

	/**
	 * 
	 * @Title: sort
	 * @Description:插入排序算法,未指定排序规则
	 * @throws Exception
	 */
	@Test
	public <T extends Object> void sort() throws Exception {
		Integer[] array = { 4, 6, 32, 65, 11, 33, 100, 1 };
		array = SortInsertUtil.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	/**
	 * 
	 * @Title: sortWithRule
	 * @Description:插入排序算法,指定排序规则
	 */
	@Test
	public <T extends Object> void sortWithRule() {
		Integer[] array = { 4, 6, 32, 65, 11, 33, 100, 1 };
		array = SortInsertUtil.sort(array, new SortRuleIntegerTest());
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
