package org.jlf.common.util.sort;

import org.jlf.common.util.sort.rule.SortRule;
import org.jlf.common.util.sort.rule.fac.SortRuleFactory;

/**
 * 
 * @ClassName: SortBubbleUtil
 * @Description:冒泡排序算法工具类
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortBubbleUtil {

	/**
	 * 
	 * @Title: sort
	 * @Description:冒泡排序算法,根据待排序的数据类型获取默认排序规则
	 * @param array
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T[] sort(T[] array) {
		Class<?> arrCls = array.getClass();
		Class<T> TCls = (Class<T>) arrCls.getComponentType();
		SortRule<T> rule = SortRuleFactory.getSortRule(TCls);

		return sort(array, rule);

	}

	/**
	 * 
	 * @Title: sort
	 * @Description:冒泡排序算法,指定排序规则
	 * @param array
	 * @param rule
	 * @return
	 */
	public static <T extends Object> T[] sort(T[] array, SortRule<T> rule) {
		if (array == null || array.length == 0) {
			return array;
		}

		int length = array.length;
		// 外层：需要length-1次循环比较
		for (int i = 0; i < length - 1; i++) {
			// 内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
			for (int j = 0; j < length - 1 - i; j++) {
				T t1 = array[j];
				T t2 = array[j + 1];
				if (!rule.compare(t1, t2)) {
					swap(array, j, j + 1);
				}

			}
		}
		return array;

	}

	/**
	 * 
	 * @Title: swap
	 * @Description:交换数组中的位置
	 * @param array
	 * @param i
	 * @param j
	 */
	private static <T extends Object> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
