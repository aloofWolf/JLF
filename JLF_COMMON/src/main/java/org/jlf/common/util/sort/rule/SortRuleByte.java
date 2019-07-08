package org.jlf.common.util.sort.rule;

/**
 * 
    * @ClassName: SortRuleByte
    * @Description:byte排序规则实现
    * @author Lone Wolf
    * @date 2019年7月4日
 */
public class SortRuleByte implements SortRule<Byte>{

	@Override
	public boolean compare(Byte t1, Byte t2) {
		return t1 <= t2;
	}

}
