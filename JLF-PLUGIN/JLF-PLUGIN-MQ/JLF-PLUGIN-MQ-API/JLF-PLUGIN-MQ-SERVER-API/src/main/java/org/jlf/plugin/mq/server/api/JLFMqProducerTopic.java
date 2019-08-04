package org.jlf.plugin.mq.server.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFMqProducerTopic
 * @Description:主题模式的生产者接口
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFMqProducerTopic {

	/**
	 * 
	 * @Title: send
	 * @Description:发送消息
	 * @param name
	 * @param obj
	 */
	public void send(String name, Serializable obj);

}
