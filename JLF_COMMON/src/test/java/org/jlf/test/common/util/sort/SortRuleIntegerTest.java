package org.jlf.test.common.util.sort;

import org.jlf.common.util.sort.rule.SortRule;

/**
 * 
 * @ClassName: SortRuleInteger
 * @Description:int自定义排序规则实现
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleIntegerTest implements SortRule<Integer> {

	@Override
	public boolean compare(Integer t1, Integer t2) {
		return t1 > t2;
	}

}
