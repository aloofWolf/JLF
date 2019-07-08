package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMAVCConnection
 * @Description:�����ݿ�����������ע��
 * @author Lone Wolf
 * @date 2019��5��27��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface JLFMVCTrans {
	
	String dbName() default "";

}
