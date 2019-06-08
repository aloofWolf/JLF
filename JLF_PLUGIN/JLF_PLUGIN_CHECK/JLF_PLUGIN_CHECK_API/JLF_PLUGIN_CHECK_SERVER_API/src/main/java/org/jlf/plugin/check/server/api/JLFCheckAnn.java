package org.jlf.plugin.check.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JAFCheckAnn
 * @Description:校验注解
 * @author Lone Wolf
 * @date 2019年5月22日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface JLFCheckAnn {

	/**
	 * @Title: isNull
	 * @Description:是否允许为空
	 * @return
	 */
	boolean isNull() default false;

	/**
	 * @Title: maxLength
	 * @Description:字符串最大长度的
	 * @return
	 */
	int maxLength() default 255;

	/**
	 * @Title: minLength
	 * @Description:字符串最小长度
	 * @return
	 */
	int minLength() default 0;

	/**
	 * @Title: maxValue
	 * @Description:数值类型最大值
	 * @return
	 */
	double maxValue() default 99999999.99;

	/**
	 * @Title: minValue
	 * @Description:数值类型最小值
	 * @return
	 */
	double minValue() default -99999999.99;

	/**
	 * @Title: minDate
	 * @Description:日期类型最小值
	 * @return
	 */
	String minDate() default "1800-01-01 00:00:00";

	/**
	 * @Title: maxDate
	 * @Description:日期类型最大值
	 * @return
	 */
	String maxDate() default "3000-13-31 23:59:59";

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
