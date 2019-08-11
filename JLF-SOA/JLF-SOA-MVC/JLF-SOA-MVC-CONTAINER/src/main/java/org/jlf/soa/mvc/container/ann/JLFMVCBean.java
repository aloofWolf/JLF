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
 * @Description: ��Ҫ��ɨ���bean��ע��
 * @author Lone Wolf
 * @date 2019��8��11��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Inherited
public @interface JLFMVCBean {

	/**
	 * 
	 * @Title: generate
	 * @Description:bean��������class
	 * @return
	 */
	Class<?> generate() default JLFMVCBeanGenerateReflect.class;

}
