package org.jlf.soa.mvc.web.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jlf.soa.mvc.container.ann.JLFMVCBean;

/**
 * 
 * @ClassName: JLFMVCRouteCls
 * @Description:·�ɵ�class���ע��
 * @author Lone Wolf
 * @date 2019��5��27��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE,ElementType.METHOD })
@JLFMVCBean
public @interface JLFMVCRoute {
	
	public static final String contextPath = "comm";

	/**
	 * 
	 * @Title: name
	 * @Description:·�ɵ�class�������
	 * @return
	 */
	String name() default "";

	/**
	 * 
	 * @Title: routeClsType
	 * @Description: routeClsType
	 * @return
	 */
	int routeClsType() default 0; // 0:��ͨclass 1:�ӿ�class 2:ʵ����
	
	
	int jumpWay() default 1; // ��ת��ʽ

	String jumpUrl() default "";// ��תurl
	
	String contextPath() default contextPath;
}
