package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleInteger
 * @Description:int�������ʵ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleInteger implements SortRule<Integer> {

	@Override
	public boolean compare(Integer t1, Integer t2) {
		return t1 <= t2;
	}

}
