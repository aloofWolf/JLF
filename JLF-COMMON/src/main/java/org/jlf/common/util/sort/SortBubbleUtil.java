package org.jlf.common.util.sort;

import org.jlf.common.util.sort.rule.SortRule;
import org.jlf.common.util.sort.rule.fac.SortRuleFactory;

/**
 * 
 * @ClassName: SortBubbleUtil
 * @Description:ð�������㷨������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortBubbleUtil {

	/**
	 * 
	 * @Title: sort
	 * @Description:ð�������㷨,���ݴ�������������ͻ�ȡĬ���������
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
	 * @Description:ð�������㷨,ָ���������
	 * @param array
	 * @param rule
	 * @return
	 */
	public static <T extends Object> T[] sort(T[] array, SortRule<T> rule) {
		if (array == null || array.length == 0) {
			return array;
		}

		int length = array.length;
		// ��㣺��Ҫlength-1��ѭ���Ƚ�
		for (int i = 0; i < length - 1; i++) {
			// �ڲ㣺ÿ��ѭ����Ҫ�����ȽϵĴ�����ÿ�αȽϺ󣬶��Ὣ��ǰ�������ŵ����λ�ã�����ÿ�αȽϴ����ݼ�һ��
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
	 * @Description:���������е�λ��
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
