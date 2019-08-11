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
@Target({ ElementType.TYPE })
@JLFMVCBean
public @interface JLFMVCRoute {

	/**
	 * 
	 * @Title: name
	 * @Description:·�ɵ�class�������
	 * @return
	 */
	String name() default "";
}
