package org.jlf.soa.mvc.metadata.ann;

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
}
