package org.jlf.soa.mvc.web.route;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCRouteCls
 * @Description:路由的class类的注解
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFMVCRouteCls {

	/**
	 * 
	 * @Title: name
	 * @Description:路由的class类的名称
	 * @return
	 */
	String name() default "";

	/**
	 * 
	 * @Title: type
	 * @Description:路由类型 0:普通路由 1:接口或抽象路由 2:接口或抽象路由的实现
	 * @return
	 */
	int type() default 0;
}
