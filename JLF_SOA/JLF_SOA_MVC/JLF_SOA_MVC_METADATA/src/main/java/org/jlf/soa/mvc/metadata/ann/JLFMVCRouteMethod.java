package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCRouteMethod
 * @Description:·�ɷ���ע��
 * @author Lone Wolf
 * @date 2019��5��27��
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface JLFMVCRouteMethod {

	String name(); // ·�ɷ�������

	int jumpWay() default 1; // ��ת��ʽ

	String jumpUrl() default "";// ��תurl

}
