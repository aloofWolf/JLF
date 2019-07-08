package org.jlf.common.util.sort.rule;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: SortRuleBigDecimal
 * @Description:BigDecimal排序规则实现
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleBigDecimal implements SortRule<BigDecimal> {

	@Override
	public boolean compare(BigDecimal t1, BigDecimal t2) {
		return t1.compareTo(t2) <= 0;
	}

}
