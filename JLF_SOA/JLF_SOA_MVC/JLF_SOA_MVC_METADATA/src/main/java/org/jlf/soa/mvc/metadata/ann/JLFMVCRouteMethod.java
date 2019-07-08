package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCRouteMethod
 * @Description:路由方法注解
 * @author Lone Wolf
 * @date 2019年5月27日
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface JLFMVCRouteMethod {

	String name(); // 路由方法名称

	int jumpWay() default 1; // 跳转方式

	String jumpUrl() default "";// 跳转url

}
