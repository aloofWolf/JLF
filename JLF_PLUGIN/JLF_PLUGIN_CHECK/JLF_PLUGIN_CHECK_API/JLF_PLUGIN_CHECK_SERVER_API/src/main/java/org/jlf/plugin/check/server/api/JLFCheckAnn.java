package org.jlf.plugin.check.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JAFCheckAnn
 * @Description:У��ע��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface JLFCheckAnn {

	/**
	 * @Title: isNull
	 * @Description:�Ƿ�����Ϊ��
	 * @return
	 */
	boolean isNull() default false;

	/**
	 * @Title: maxLength
	 * @Description:�ַ�����󳤶ȵ�
	 * @return
	 */
	int maxLength() default 255;

	/**
	 * @Title: minLength
	 * @Description:�ַ�����С����
	 * @return
	 */
	int minLength() default 0;

	/**
	 * @Title: maxValue
	 * @Description:��ֵ�������ֵ
	 * @return
	 */
	double maxValue() default 99999999.99;

	/**
	 * @Title: minValue
	 * @Description:��ֵ������Сֵ
	 * @return
	 */
	double minValue() default -99999999.99;

	/**
	 * @Title: minDate
	 * @Description:����������Сֵ
	 * @return
	 */
	String minDate() default "1800-01-01 00:00:00";

	/**
	 * @Title: maxDate
	 * @Description:�����������ֵ
	 * @return
	 */
	String maxDate() default "3000-13-31 23:59:59";

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
