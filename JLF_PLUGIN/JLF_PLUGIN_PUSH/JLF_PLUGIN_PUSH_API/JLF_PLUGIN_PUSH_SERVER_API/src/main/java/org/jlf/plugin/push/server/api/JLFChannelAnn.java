package org.jlf.plugin.push.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFChannelAnn
 * @Description:渠道注解
 * @author Lone Wolf
 * @date 2019年6月7日
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFChannelAnn {

	/**
	 * 
	 * @Title: channelCode
	 * @Description:渠道编号
	 * @return
	 */
	String channelCode();

}
