package org.jlf.test.common.util.sort;

import org.jlf.common.util.sort.SortInsertUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SortInsertUtilTest
 * @Description:�������򹤾������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortInsertUtilTest {

	/**
	 * 
	 * @Title: sort
	 * @Description:���������㷨,δָ���������
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
	 * @Description:���������㷨,ָ���������
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
