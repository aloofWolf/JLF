package org.jlf.plugin.push.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFChannelAnn
 * @Description:����ע��
 * @author Lone Wolf
 * @date 2019��6��7��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFChannelAnn {

	/**
	 * 
	 * @Title: channelCode
	 * @Description:�������
	 * @return
	 */
	String channelCode();

}
