package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleShort
 * @Description:short�������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleShort implements SortRule<Short> {

	@Override
	public boolean compare(Short t1, Short t2) {
		return t1 <= t2;
	}

}
