package org.jlf.soa.mvc.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCBeanMapped
 * @Description:bean与数据库表的映射关系
 * @author Lone Wolf
 * @date 2019年5月25日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFMVCBeanTableMapped {

	/**
	 * @Title: tableName
	 * @Description:表名
	 * @return
	 */
	String tableName() default "";

	/**
	 * 
	 * @Title: desc
	 * @Description:表描述
	 * @return
	 */
	String desc() default "";

	/**
	 * 
	 * @Title: databaseType
	 * @Description:表名所在的数据库类型 ,?为占位符,从当前session中取值
	 * @return
	 */
	String dbName() default "";

	/**
	 * 
	 * @Title: cache
	 * @Description:bean是否加入缓存
	 * @return
	 */
	boolean cache() default false;

	/**
	 * 
	 * @Title: seconds
	 * @Description:缓存有效期,小于0永久缓存
	 * @return
	 */
	int seconds() default -1;
}
