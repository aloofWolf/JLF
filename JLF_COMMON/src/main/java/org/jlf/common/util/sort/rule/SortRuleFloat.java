package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleFloat
 * @Description:float�������ʵ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleFloat implements SortRule<Float> {

	@Override
	public boolean compare(Float t1, Float t2){
		return t1 <= t2;
	}

}
