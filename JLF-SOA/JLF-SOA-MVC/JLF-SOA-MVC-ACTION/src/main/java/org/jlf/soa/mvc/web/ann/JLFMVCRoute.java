package org.jlf.soa.mvc.web.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jlf.soa.mvc.container.ann.JLFMVCBean;

/**
 * 
 * @ClassName: JLFMVCRouteCls
 * @Description:路由的class类的注解
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE,ElementType.METHOD })
@JLFMVCBean
public @interface JLFMVCRoute {
	
	public static final String contextPath = "comm";

	/**
	 * 
	 * @Title: name
	 * @Description:路由的class类的名称
	 * @return
	 */
	String name() default "";

	/**
	 * 
	 * @Title: routeClsType
	 * @Description: routeClsType
	 * @return
	 */
	int routeClsType() default 0; // 0:普通class 1:接口class 2:实现类
	
	
	int jumpWay() default 1; // 跳转方式

	String jumpUrl() default "";// 跳转url
	
	String contextPath() default contextPath;
}
