package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMAVCConnection
 * @Description:打开数据库与事物连接注解
 * @author Lone Wolf
 * @date 2019年5月27日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface JLFMVCTrans {
	
	String dbName() default "";

}
