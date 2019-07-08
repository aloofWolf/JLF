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
 * @Description:bean字段与数据库字段的映射关系
 * @author Lone Wolf
 * @date 2019年7月2日
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
	 * @Description:字段描述
	 * @return
	 */
	String desc() default "";

	/**
	 * 
	 * @Title: isPrimary
	 * @Description:是否为主键
	 * @return
	 */
	boolean isPrimary() default isPrimary;

	/**
	 * 
	 * @Title: isAllowNull
	 * @Description:是否非空
	 * @return
	 */
	boolean isNotNull() default isNotNull;

	/**
	 * 
	 * @Title: isUnique
	 * @Description:是否唯一
	 * @return
	 */
	boolean isUnique() default isUnique;

	/**
	 * 
	 * @Title: uniqueName
	 * @Description:唯一约束名称
	 * @return
	 */
	String uniqueName() default "";

	/**
	 * 
	 * @Title: joinUniqueField
	 * @Description:联合唯一约束关联字段
	 * @return
	 */
	String[] joinUniqueField() default "";

	/**
	 * 
	 * @Title: strLength
	 * @Description:字符串类型长度
	 * @return
	 */
	int strLength() default strLength;

	/**
	 * 
	 * @Title: intLength
	 * @Description:int类型长度
	 * @return
	 */
	int intLength() default intLength;

	/**
	 * 
	 * @Title: LongLength
	 * @Description:long类型长度
	 * @return
	 */
	int LongLength() default LongLength;

	/**
	 * 
	 * @Title: doubleLenth
	 * @Description:浮点数类型长度
	 * @return
	 */
	int[] doubleLenth() default { 10, 2 };

	/**
	 * 
	 * @Title: defaultValue
	 * @Description:默认值
	 * @return
	 */
	String defaultValue() default "";

	/**
	 * 
	 * @Title: isSkipMapped
	 * @Description:是否跳过匹配
	 * @return
	 */
	boolean isSkipMapped() default false;

}
