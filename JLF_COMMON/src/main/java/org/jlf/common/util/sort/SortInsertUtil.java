package org.jlf.common.util.sort;

import org.jlf.common.util.sort.rule.SortRule;
import org.jlf.common.util.sort.rule.fac.SortRuleFactory;

/**
 * 
 * @ClassName: SortInsertUtil
 * @Description:���������㷨������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortInsertUtil {

	/**
	 * 
	 * @Title: sort
	 * @Description:���������㷨,���ݴ�������������ͻ�ȡĬ���������
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
	 * @Description:���������㷨,֪���������
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
			T temp = array[i]; // ��ȡ�����������ݱ��棬��Ϊ�����λ�����л�Ѹ��ǵ���������
			while (j >= 0 && !rule.compare(array[j], temp)) { // ������Ǳȴ��������ݴ󣬾ͺ���
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp; // �ҵ��ȴ���������С��λ�ã������������ݲ���
		}
		return array;

	}

}
