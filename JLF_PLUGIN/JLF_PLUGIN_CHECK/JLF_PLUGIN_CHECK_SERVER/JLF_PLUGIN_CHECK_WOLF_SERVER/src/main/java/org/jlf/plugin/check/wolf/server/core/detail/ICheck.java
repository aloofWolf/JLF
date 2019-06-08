package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: ICheck
 * @Description:Check基类
 * @author Lone Wolf
 * @date 2019年5月24日
 * @param <T>
 */
public abstract class ICheck<T extends Object> {

	public static final String NULL_EXCEPTION_DESC = "不能为空";
	public static final String MAX_LENGTH_EXCEPTION_DESC = "长度超过最大长度限制";
	public static final String MIN_LENGTH_EXCEPTION_DESC = "长度未达到最小长度限制";
	public static final String MAX_VALUE_EXCEPTION_DESC = "超过最大值限制";
	public static final String MIN_VALUE_EXCEPTION_DESC = "未达到最小值限制";
	public static final String MAX_DATE_EXCEPTION_DESC = "超过最大日期限制";
	public static final String MIN_DATE_EXCEPTION_DESC = "未达到最小日期限制";
	public static final String CHECKED_EXCEPTION_DESC = "未在指定范围内";

	/**
	 * 
	 * @Title: getValue
	 * @Description:从惊悚中获取field字段的值
	 * @param json
	 * @param field
	 * @return
	 * @throws Exception 
	 */
	public abstract T getValue(JLFJson json, Field field) throws Exception;

	/**
	 * 
	 * @Title: checkNull
	 * @Description:校验是否为空值
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkNull(JLFCheckAnn ann, Field field, T value) throws Exception {
		if (ann.isNull() == false && value == null) {
			throw new JLFException(getExceptionDesc(ann, field, NULL_EXCEPTION_DESC));
		}
	}

	

	/**
	 * 
	 * @Title: getExceptionDesc
	 * @Description:获取校验不同过时的异常信息
	 * @param ann
	 * @param field
	 * @param exceptionMsg
	 * @return
	 */
	protected String getExceptionDesc(JLFCheckAnn ann, Field field, String exceptionMsg) {
		String fieldDesc = ann.desc();
		if (fieldDesc == null || fieldDesc.length() <= 0) {
			fieldDesc = field.getName();
		}
		return new StringBuffer(fieldDesc).append(exceptionMsg).toString();
	}

}
