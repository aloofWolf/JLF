package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleDouble
 * @Description:double�������ʵ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleDouble implements SortRule<Double> {

	@Override
	public boolean compare(Double t1, Double t2) {
		return t1 <= t2;
	}

}
