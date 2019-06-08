package org.jlf.soa.mvc.metadata.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFMVCBeanMapped
 * @Description:bean与数据库事物映射
 * @author Lone Wolf
 * @date 2019年5月25日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface JLFMVCBeanMapped {

	/**
	 * @Title: tableName
	 * @Description:表名
	 * @return
	 */
	String tableName() default "";

	/**
	 * 
	 * @Title: databaseType
	 * @Description:表名所在的数据库类型 1:主库 2:字库
	 * @return
	 */
	String dbName() default "?";

	/**
	 * @Title: skipMapped
	 * @Description:字段是否跳过与数据库匹配
	 * @return
	 */
	boolean skipMapped() default false;

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
