package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCBeanMapped
 * @Description:bean�����ݿ���ӳ���ϵ
 * @author Lone Wolf
 * @date 2019��5��25��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFMVCBeanTableMapped {

	/**
	 * @Title: tableName
	 * @Description:����
	 * @return
	 */
	String tableName() default "";

	/**
	 * 
	 * @Title: desc
	 * @Description:������
	 * @return
	 */
	String desc() default "";

	/**
	 * 
	 * @Title: databaseType
	 * @Description:�������ڵ����ݿ����� ,?Ϊռλ��,�ӵ�ǰsession��ȡֵ
	 * @return
	 */
	String dbName() default "";

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
