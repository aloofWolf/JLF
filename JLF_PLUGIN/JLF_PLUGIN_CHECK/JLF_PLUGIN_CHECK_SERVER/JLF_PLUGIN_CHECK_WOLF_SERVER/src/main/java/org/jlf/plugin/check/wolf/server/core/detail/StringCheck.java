package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: StringCheck
 * @Description:String����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class StringCheck extends ICheck<String> {

	@Override
	public String getValue(JLFJson json, Field field) throws Exception {
		return json.getStr(field.getName());
	}

	@Override
	public void checkNull(JLFCheckAnn ann, Field field, String value) throws Exception {
		if (ann.isNull() == false && value == null) {
			throw new JLFException(getExceptionDesc(ann, field, NULL_EXCEPTION_DESC));
		}
	}

	/**
	 * 
	 * @Title: checkMaxLength
	 * @Description:��󳤶�У��
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMaxLength(JLFCheckAnn ann, Field field, String value) throws Exception {
		if (value != null) {
			int maxValue = ann.maxLength();
			if (value.length() > maxValue) {
				throw new Exception(getExceptionDesc(ann, field, MAX_VALUE_EXCEPTION_DESC));
			}
		}
	}

	/**
	 * 
	 * @Title: checkMinLength
	 * @Description:��С�̶�У��
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMinLength(JLFCheckAnn ann, Field field, String value) throws Exception {
		if (value != null) {
			int minValue = ann.minLength();
			if (value.length() < minValue) {
				throw new Exception(getExceptionDesc(ann, field, MIN_VALUE_EXCEPTION_DESC));
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
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void check(JLFCheckAnn ann, Field field, String value) throws Exception {
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
