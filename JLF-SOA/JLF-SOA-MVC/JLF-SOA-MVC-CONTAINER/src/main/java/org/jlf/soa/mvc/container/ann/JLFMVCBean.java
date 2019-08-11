package org.jlf.soa.mvc.container.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jlf.soa.mvc.container.generate.JLFMVCBeanGenerateReflect;

/**
 * 
 * @ClassName: JLFMVCBean
 * @Description: 需要被扫描的bean的注解
 * @author Lone Wolf
 * @date 2019年8月11日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Inherited
public @interface JLFMVCBean {

	/**
	 * 
	 * @Title: generate
	 * @Description:bean生成器的class
	 * @return
	 */
	Class<?> generate() default JLFMVCBeanGenerateReflect.class;

}
