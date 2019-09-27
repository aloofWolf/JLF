package org.jlf.plugin.server.core.check.custom.detail;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

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
	
	private static final String ERR_MSG = "参数校验失败,%s%s";

	/**
	 * 
	    * @Title: getValue
	    * @Description:从惊悚中获取field字段的值
	    * @param json
	    * @param CheckObj
	    * @param type
	    * @param checkCls
	    * @param checkName
	    * @return
	 */
	public abstract T getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName);

	/**
	 * 
	 * @Title: checkNull
	 * @Description:校验是否为空值
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkNull(JLFCheckAnn ann, String checkName, T value) {
		boolean isNull = (ann == null ? JLFCheckAnn.isNull : ann.isNull());
		if (isNull == false && value == null) {
			throw new JLFException(getExceptionDesc(ann, checkName, NULL_EXCEPTION_DESC));
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
	protected String getExceptionDesc(JLFCheckAnn ann, String checkName, String exceptionMsg) {
		String fieldDesc = (ann == null ? null : ann.desc());
		if (fieldDesc == null || fieldDesc.length() <= 0) {
			fieldDesc = checkName;
		}
		return String.format(ERR_MSG, fieldDesc,exceptionMsg);
	}

}
