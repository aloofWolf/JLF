package org.jlf.soa.mvc.metadata.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCBeanMapped
 * @Description:bean�����ݿ�����ӳ��
 * @author Lone Wolf
 * @date 2019��5��25��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface JLFMVCBeanMapped {

	/**
	 * @Title: tableName
	 * @Description:����
	 * @return
	 */
	String tableName() default "";

	/**
	 * 
	 * @Title: databaseType
	 * @Description:�������ڵ����ݿ����� 1:���� 2:�ֿ�
	 * @return
	 */
	String dbName() default "?";

	/**
	 * @Title: skipMapped
	 * @Description:�ֶ��Ƿ����������ݿ�ƥ��
	 * @return
	 */
	boolean skipMapped() default false;

	/**
	 * 
	 * @Title: cache
	 * @Description:bean�Ƿ���뻺��
	 * @return
	 */
	boolean cache() default false;

	/**
	 * 
	 * @Title: seconds
	 * @Description:������Ч��,С��0���û���
	 * @return
	 */
	int seconds() default -1;
}
