package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleString
 * @Description:string排序规则
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleString implements SortRule<String> {

	@Override
	public boolean compare(String t1, String t2) {
		return t1.compareTo(t2) <= 0;
	}

}
