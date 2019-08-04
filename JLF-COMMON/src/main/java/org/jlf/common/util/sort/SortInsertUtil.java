package org.jlf.common.util.sort;

import org.jlf.common.util.sort.rule.SortRule;
import org.jlf.common.util.sort.rule.fac.SortRuleFactory;

/**
 * 
 * @ClassName: SortInsertUtil
 * @Description:插入排序算法工具类
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortInsertUtil {

	/**
	 * 
	 * @Title: sort
	 * @Description:插入排序算法,根据待排序的数据类型获取默认排序规则
	 * @param array
	 * @return
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
	 * @Description:插入排序算法,知道排序规则
	 * @param array
	 * @param rule
	 * @return
	 */
	public static <T extends Object> T[] sort(T[] array, SortRule<T> rule) {
		if (array == null || array.length == 0) {
			return array;
		}

		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			T temp = array[i]; // 先取出待插入数据保存，因为向后移位过程中会把覆盖掉待插入数
			while (j >= 0 && !rule.compare(array[j], temp)) { // 如果待是比待插入数据大，就后移
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp; // 找到比待插入数据小的位置，将待插入数据插入
		}
		return array;

	}

}
