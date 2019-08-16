package org.jlf.plugin.server.core.check.custom.detail;

import java.math.BigDecimal;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: NumberCheck
 * @Description:��������У��
 * @author Lone Wolf
 * @date 2019��5��24��
 * @param <N>
 */
public class NumberCheck<N extends Number> extends ICheck<N> {

	@SuppressWarnings("unchecked")
	@Override
	public N getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return (N) json.get(checkName);
	}

	/**
	 * 
	 * @Title: numberToBigdecimal
	 * @Description:number����תBigdecimal
	 * @param fieldValue
	 * @return
	 */
	public BigDecimal numberToBigdecimal(N fieldValue) {
		return new BigDecimal(fieldValue.doubleValue());
	}

	/**
	 * 
	 * @Title: doubleBigdecimal
	 * @Description:double����תBigdecimal
	 * @param value
	 * @return
	 */
	public BigDecimal doubleBigdecimal(double value) {
		return new BigDecimal(value);
	}

	/**
	 * 
	 * @Title: checkMaxValue
	 * @Description:���ֵУ��
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMaxValue(JLFCheckAnn ann, String checkName, N value) {
		if (value != null) {
			double maxValue = (ann == null ? JLFCheckAnn.maxValue : ann.maxValue());
			if (numberToBigdecimal(value).compareTo(doubleBigdecimal(maxValue)) == 1) {
				throw new JLFException(getExceptionDesc(ann, checkName, MAX_VALUE_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: checkMinValue
	 * @Description:��СֵУ��
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMinValue(JLFCheckAnn ann, String checkName, N value) {
		if (value != null) {
			double minValue = (ann == null ? JLFCheckAnn.minValue : ann.minValue());
			if (numberToBigdecimal(value).compareTo(doubleBigdecimal(minValue)) == -1) {
				throw new JLFException(getExceptionDesc(ann, checkName, MIN_VALUE_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: check
	 * @Description:У���Ƿ���ָ����Χ��
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void check(JLFCheckAnn ann, String checkName, N value) {
		if (value != null) {
			String[] checks = (ann == null ? JLFCheckAnn.checked : ann.checked());
			if (checks != null && checks.length > 0) {
				String strValue = value.toString();
				for (String check : checks) {
					if (strValue.equals(check)) {
						return;
					}
				}
				throw new JLFException(getExceptionDesc(ann, checkName, CHECKED_EXCEPTION_DESC));
			}
		}
	}
}
