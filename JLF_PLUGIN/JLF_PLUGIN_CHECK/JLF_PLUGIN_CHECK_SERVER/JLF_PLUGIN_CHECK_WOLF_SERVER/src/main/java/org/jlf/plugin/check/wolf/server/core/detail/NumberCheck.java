package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: NumberCheck
 * @Description:数字类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 * @param <N>
 */
public class NumberCheck<N extends Number> extends ICheck<N> {

	@SuppressWarnings("unchecked")
	@Override
	public N getValue(JLFJson json, Field field) throws Exception {
		return (N) json.get(field.getName());
	}

	/**
	 * 
	 * @Title: numberToBigdecimal
	 * @Description:number类型转Bigdecimal
	 * @param fieldValue
	 * @return
	 */
	public BigDecimal numberToBigdecimal(N fieldValue) {
		return new BigDecimal(fieldValue.doubleValue());
	}

	/**
	 * 
	 * @Title: doubleBigdecimal
	 * @Description:double类型转Bigdecimal
	 * @param value
	 * @return
	 */
	public BigDecimal doubleBigdecimal(double value) {
		return new BigDecimal(value);
	}

	/**
	 * 
	 * @Title: checkMaxValue
	 * @Description:最大值校验
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMaxValue(JLFCheckAnn ann, Field field, N value) throws Exception {
		if (value != null) {
			double maxValue = ann.maxValue();
			if (numberToBigdecimal(value).compareTo(doubleBigdecimal(maxValue)) == 1) {
				throw new Exception(getExceptionDesc(ann, field, MAX_VALUE_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: checkMinValue
	 * @Description:最小值校验
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMinValue(JLFCheckAnn ann, Field field, N value) throws Exception {
		if (value != null) {
			double minValue = ann.minValue();
			if (numberToBigdecimal(value).compareTo(doubleBigdecimal(minValue)) == -1) {
				throw new Exception(getExceptionDesc(ann, field, MIN_VALUE_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: check
	 * @Description:校验是否在指定范围内
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void check(JLFCheckAnn ann, Field field, N value) throws Exception {
		if (value != null) {
			String[] checks = ann.checked();
			if (checks != null && checks.length > 0) {
				String strValue = value.toString();
				for (String check : checks) {
					if (strValue.equals(check)) {
						return;
					}
				}
				throw new JLFException(getExceptionDesc(ann, field, CHECKED_EXCEPTION_DESC));
			}
		}
	}
}
