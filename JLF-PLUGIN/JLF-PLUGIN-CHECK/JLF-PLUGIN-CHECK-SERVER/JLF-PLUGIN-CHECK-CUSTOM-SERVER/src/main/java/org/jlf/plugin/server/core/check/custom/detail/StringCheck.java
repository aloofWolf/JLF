package org.jlf.plugin.server.core.check.custom.detail;

import java.lang.reflect.Field;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: StringCheck
 * @Description:String类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class StringCheck extends ICheck<String> {

	@Override
	public String getValue(JLFJson json, Field field) {
		return json.getStr(field.getName());
	}

	@Override
	public void checkNull(JLFCheckAnn ann, Field field, String value) {
		boolean isNull = (ann == null ? JLFCheckAnn.isNull : ann.isNull());
		if (isNull == false && (value == null || value.length() == 0)) {
			throw new JLFException(getExceptionDesc(ann, field, NULL_EXCEPTION_DESC));
		}
	}

	/**
	 * 
	 * @Title: checkMaxLength
	 * @Description:最大长度校验
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMaxLength(JLFCheckAnn ann, Field field, String value) {
		if (value != null) {
			int maxLength = (ann == null ? JLFCheckAnn.maxLength : ann.maxLength());
			if (value.length() > maxLength) {
				throw new JLFException(getExceptionDesc(ann, field, MAX_VALUE_EXCEPTION_DESC));
			}
		}
	}

	/**
	 * 
	 * @Title: checkMinLength
	 * @Description:最小长度校验
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMinLength(JLFCheckAnn ann, Field field, String value) {
		if (value != null) {
			int minLength = (ann == null ? JLFCheckAnn.minLength : ann.minLength());
			if (value.length() < minLength) {
				throw new JLFException(getExceptionDesc(ann, field, MIN_VALUE_EXCEPTION_DESC));
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
	public void check(JLFCheckAnn ann, Field field, String value) {
		if (value != null) {
			String[] checks = (ann == null ? JLFCheckAnn.checked : ann.checked());
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
