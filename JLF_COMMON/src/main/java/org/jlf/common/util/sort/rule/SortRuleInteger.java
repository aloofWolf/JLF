package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleInteger
 * @Description:int排序规则实现
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleInteger implements SortRule<Integer> {

	@Override
	public boolean compare(Integer t1, Integer t2) {
		return t1 <= t2;
	}

}
