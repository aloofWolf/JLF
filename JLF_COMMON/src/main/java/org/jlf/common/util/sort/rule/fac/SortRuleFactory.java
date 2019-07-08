package org.jlf.common.util.sort.rule.fac;

import java.math.BigDecimal;
import java.util.Date;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.sort.rule.SortRule;
import org.jlf.common.util.sort.rule.SortRuleBigDecimal;
import org.jlf.common.util.sort.rule.SortRuleByte;
import org.jlf.common.util.sort.rule.SortRuleDate;
import org.jlf.common.util.sort.rule.SortRuleDouble;
import org.jlf.common.util.sort.rule.SortRuleFloat;
import org.jlf.common.util.sort.rule.SortRuleInteger;
import org.jlf.common.util.sort.rule.SortRuleLong;
import org.jlf.common.util.sort.rule.SortRuleShort;
import org.jlf.common.util.sort.rule.SortRuleString;

/**
 * 
 * @ClassName: SortRuleFactory
 * @Description:排序算法规则工厂类
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class SortRuleFactory {

	/**
	 * 
	 * @Title: getSortRule
	 * @Description:根据排序数据的类型获取默认排序规则
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> SortRule<T> getSortRule(Class<T> cls) {

		SortRule<?> rule = null;

		if (cls.equals(Byte.class)) {
			rule = new SortRuleByte();
		} else if (cls.equals(Short.class)) {
			rule = new SortRuleShort();
		} else if (cls.equals(Integer.class)) {
			rule = new SortRuleInteger();
		} else if (cls.equals(Long.class)) {
			rule = new SortRuleLong();
		} else if (cls.equals(Double.class)) {
			rule = new SortRuleDouble();
		} else if (cls.equals(Float.class)) {
			rule = new SortRuleFloat();
		} else if (cls.equals(BigDecimal.class)) {
			rule = new SortRuleBigDecimal();
		} else if (cls.equals(String.class)) {
			rule = new SortRuleString();
		} else if (cls.equals(Date.class)) {
			rule = new SortRuleDate();
		} else {
			throw new JLFException("暂未支持此类型:" + cls);
		}

		return (SortRule<T>) rule;

	}

}
