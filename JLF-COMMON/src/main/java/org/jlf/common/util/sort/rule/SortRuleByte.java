package org.jlf.common.util.sort.rule;

/**
 * 
    * @ClassName: SortRuleByte
    * @Description:byte�������ʵ��
    * @author Lone Wolf
    * @date 2019��7��4��
 */
public class SortRuleByte implements SortRule<Byte>{

	@Override
	public boolean compare(Byte t1, Byte t2) {
		return t1 <= t2;
	}

}
