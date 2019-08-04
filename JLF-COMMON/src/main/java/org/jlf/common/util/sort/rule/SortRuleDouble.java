package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleDouble
 * @Description:double排序规则实现
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleDouble implements SortRule<Double> {

	@Override
	public boolean compare(Double t1, Double t2) {
		return t1 <= t2;
	}

}
