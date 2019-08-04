package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleLong
 * @Description:long排序规则
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleLong implements SortRule<Long> {

	@Override
	public boolean compare(Long t1, Long t2) {
		return t1 <= t2;
	}

}
