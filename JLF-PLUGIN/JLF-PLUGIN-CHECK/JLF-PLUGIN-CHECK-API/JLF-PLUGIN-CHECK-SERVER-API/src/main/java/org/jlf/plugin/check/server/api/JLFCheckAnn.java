package org.jlf.plugin.check.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFCheckAnn
 * @Description:У��ע��
 * @author Lone Wolf
 * @date 2019��5��22��
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
	 * @Description:�Ƿ�����Ϊ��
	 * @return
	 */
	boolean isNull() default isNull;

	/**
	 * @Title: maxLength
	 * @Description:�ַ�����󳤶ȵ�
	 * @return
	 */
	int maxLength() default maxLength;

	/**
	 * @Title: minLength
	 * @Description:�ַ�����С����
	 * @return
	 */
	int minLength() default minLength;

	/**
	 * @Title: maxValue
	 * @Description:��ֵ�������ֵ
	 * @return
	 */
	double maxValue() default maxValue;

	/**
	 * @Title: minValue
	 * @Description:��ֵ������Сֵ
	 * @return
	 */
	double minValue() default minValue;

	/**
	 * @Title: minDate
	 * @Description:����������Сֵ
	 * @return
	 */
	String minDate() default minDate;

	/**
	 * @Title: maxDate
	 * @Description:�����������ֵ
	 * @return
	 */
	String maxDate() default maxDate;

	/**
	 * @Title: checked
	 * @Description:�ض�ֵУ��
	 * @return
	 */
	String[] checked() default {};

	/**
	 * @Title: isSkipValidate
	 * @Description:�Ƿ�����У��͸�ֵ
	 * @return
	 */
	boolean isSkipValidate() default false;

	/**
	 * @Title: desc
	 * @Description:�ֶ�����
	 * @return
	 */
	String desc() default "";

}
