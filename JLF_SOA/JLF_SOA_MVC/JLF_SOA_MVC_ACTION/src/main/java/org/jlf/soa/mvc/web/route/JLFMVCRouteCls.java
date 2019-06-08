package org.jlf.soa.mvc.web.route;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCRouteCls
 * @Description:·�ɵ�class���ע��
 * @author Lone Wolf
 * @date 2019��5��27��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFMVCRouteCls {

	/**
	 * 
	 * @Title: name
	 * @Description:·�ɵ�class�������
	 * @return
	 */
	String name() default "";

	/**
	 * 
	 * @Title: type
	 * @Description:·������ 0:��ͨ·�� 1:�ӿڻ����·�� 2:�ӿڻ����·�ɵ�ʵ��
	 * @return
	 */
	int type() default 0;
}
