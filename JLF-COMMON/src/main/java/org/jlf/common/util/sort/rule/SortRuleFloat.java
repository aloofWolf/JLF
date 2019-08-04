package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRuleFloat
 * @Description:float排序规则实现
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleFloat implements SortRule<Float> {

	@Override
	public boolean compare(Float t1, Float t2){
		return t1 <= t2;
	}

}
