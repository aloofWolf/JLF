package org.jlf.common.util.sort.rule;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: SortRuleBigDecimal
 * @Description:BigDecimal�������ʵ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleBigDecimal implements SortRule<BigDecimal> {

	@Override
	public boolean compare(BigDecimal t1, BigDecimal t2) {
		return t1.compareTo(t2) <= 0;
	}

}
