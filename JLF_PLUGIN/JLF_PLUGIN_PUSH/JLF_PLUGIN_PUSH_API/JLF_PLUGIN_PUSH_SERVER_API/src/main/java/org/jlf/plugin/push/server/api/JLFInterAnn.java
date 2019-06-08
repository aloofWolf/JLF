package org.jlf.plugin.push.server.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: JLFInterAnn
 * @Description:�ӿ�ע��
 * @author Lone Wolf
 * @date 2019��6��7��
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface JLFInterAnn {

	/**
	 * 
	 * @Title: channelCode
	 * @Description:�������
	 * @return
	 */
	String channelCode();

	/**
	 * 
	 * @Title: interCode
	 * @Description:�ӿڱ��
	 * @return
	 */
	String interCode();

}
