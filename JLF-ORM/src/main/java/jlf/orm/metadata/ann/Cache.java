package jlf.orm.metadata.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lone Wolf
 * @ClassName: Cache
 * @Description: 缓存注解, 需要缓存的实体对象
 * @date 2019年9月10日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Cache {

    int period() default 0; // 有效期

}
