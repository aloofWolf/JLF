package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;
import java.util.Date;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.DateUtil;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: DateCheck
 * @Description:��������У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class DateCheck extends ICheck<Date> {

	@Override
	public Date getValue(JLFJson json, Field field) {
		return json.getDate(field.getName());
	}

	/**
	 * 
	 * @Title: checkMaxDate
	 * @Description:�������ֵУ��
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMaxDate(JLFCheckAnn ann, Field field, Date value) {
		if (value != null) {
			String maxDateStr = (ann == null?JLFCheckAnn.maxDate:ann.maxDate());
			Date date = DateUtil.formatDate(maxDateStr, DateUtil.DEFAULT_DATETIMEPATTERN);
			if (value.after(date)) {
				throw new JLFException(getExceptionDesc(ann, field, MAX_DATE_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: checkMaxDate
	 * @Description:������СֵУ��
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMinDate(JLFCheckAnn ann, Field field, Date value) {
		if (value != null) {
			String minDateStr = (ann == null?JLFCheckAnn.minDate:ann.minDate());
			Date date = DateUtil.formatDate(minDateStr, DateUtil.DEFAULT_DATETIMEPATTERN);
			if (value.before(date)) {
				throw new JLFException(getExceptionDesc(ann, field, MAX_DATE_EXCEPTION_DESC));
			}
		}

	}

}
