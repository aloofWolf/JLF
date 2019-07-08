package org.jlf.common.util.sort.rule;

import java.util.Date;

import org.jlf.common.util.DateUtil;

/**
 * 
 * @ClassName: SortRuleDate
 * @Description:date�������ʵ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class SortRuleDate implements SortRule<Date> {

	@Override
	public boolean compare(Date t1, Date t2) {
		return DateUtil.compareData(t1, t2) <= 0;
	}

}
