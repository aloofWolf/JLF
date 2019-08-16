package org.jlf.plugin.check.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFCheckAnn
 * @Description:校验注解
 * @author Lone Wolf
 * @date 2019年5月22日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD,ElementType.PARAMETER })
public @interface JLFCheckAnn {
	
	public static final boolean isNull = false;
	public static final int maxLength = 255;
	public static final int minLength = 0;
	public static final double maxValue = 99999999.99;
	public static final double minValue = -99999999.99;
	public static final String minDate = "1800-01-01 00:00:00";
	public static final String maxDate = "3000-13-31 23:59:59";
	public static final String[] checked = {};

	/**
	 * @Title: isNull
	 * @Description:是否允许为空
	 * @return
	 */
	boolean isNull() default isNull;

	/**
	 * @Title: maxLength
	 * @Description:字符串最大长度的
	 * @return
	 */
	int maxLength() default maxLength;

	/**
	 * @Title: minLength
	 * @Description:字符串最小长度
	 * @return
	 */
	int minLength() default minLength;

	/**
	 * @Title: maxValue
	 * @Description:数值类型最大值
	 * @return
	 */
	double maxValue() default maxValue;

	/**
	 * @Title: minValue
	 * @Description:数值类型最小值
	 * @return
	 */
	double minValue() default minValue;

	/**
	 * @Title: minDate
	 * @Description:日期类型最小值
	 * @return
	 */
	String minDate() default minDate;

	/**
	 * @Title: maxDate
	 * @Description:日期类型最大值
	 * @return
	 */
	String maxDate() default maxDate;

	/**
	 * @Title: checked
	 * @Description:特定值校验
	 * @return
	 */
	String[] checked() default {};

	/**
	 * @Title: isSkipValidate
	 * @Description:是否跳过校验和赋值
	 * @return
	 */
	boolean isSkipValidate() default false;

	/**
	 * @Title: desc
	 * @Description:字段描述
	 * @return
	 */
	String desc() default "";

}
