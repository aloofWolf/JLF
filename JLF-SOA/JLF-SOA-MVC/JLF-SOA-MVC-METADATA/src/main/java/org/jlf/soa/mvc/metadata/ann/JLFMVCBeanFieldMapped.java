package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
/**
 * 
 * @ClassName: JLFMVCBeanFieldMapped
 * @Description:bean�ֶ������ݿ��ֶε�ӳ���ϵ
 * @author Lone Wolf
 * @date 2019��7��2��
 */
public @interface JLFMVCBeanFieldMapped {

	public static final boolean isPrimary = false;
	public static final boolean isNotNull = true;
	public static final boolean isUnique = false;
	public static final int strLength = 50;
	public static final int intLength = 10;
	public static final int LongLength = 20;
	public static final int[] doubleLenth = { 10, 2 };

	/**
	 * 
	 * @Title: desc
	 * @Description:�ֶ�����
	 * @return
	 */
	String desc() default "";

	/**
	 * 
	 * @Title: isPrimary
	 * @Description:�Ƿ�Ϊ����
	 * @return
	 */
	boolean isPrimary() default isPrimary;

	/**
	 * 
	 * @Title: isAllowNull
	 * @Description:�Ƿ�ǿ�
	 * @return
	 */
	boolean isNotNull() default isNotNull;

	/**
	 * 
	 * @Title: isUnique
	 * @Description:�Ƿ�Ψһ
	 * @return
	 */
	boolean isUnique() default isUnique;

	/**
	 * 
	 * @Title: uniqueName
	 * @Description:ΨһԼ������
	 * @return
	 */
	String uniqueName() default "";

	/**
	 * 
	 * @Title: joinUniqueField
	 * @Description:����ΨһԼ�������ֶ�
	 * @return
	 */
	String[] joinUniqueField() default "";

	/**
	 * 
	 * @Title: strLength
	 * @Description:�ַ������ͳ���
	 * @return
	 */
	int strLength() default strLength;

	/**
	 * 
	 * @Title: intLength
	 * @Description:int���ͳ���
	 * @return
	 */
	int intLength() default intLength;

	/**
	 * 
	 * @Title: LongLength
	 * @Description:long���ͳ���
	 * @return
	 */
	int LongLength() default LongLength;

	/**
	 * 
	 * @Title: doubleLenth
	 * @Description:���������ͳ���
	 * @return
	 */
	int[] doubleLenth() default { 10, 2 };

	/**
	 * 
	 * @Title: defaultValue
	 * @Description:Ĭ��ֵ
	 * @return
	 */
	String defaultValue() default "";

	/**
	 * 
	 * @Title: isSkipMapped
	 * @Description:�Ƿ�����ƥ��
	 * @return
	 */
	boolean isSkipMapped() default false;

}
