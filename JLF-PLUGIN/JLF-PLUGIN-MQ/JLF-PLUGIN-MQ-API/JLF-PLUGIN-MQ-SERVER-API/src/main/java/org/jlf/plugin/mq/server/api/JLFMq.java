package org.jlf.plugin.mq.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.mq.user.api.JLFMqCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;

/**
 * 
 * @ClassName: JLFMq
 * @Description:消息队列api
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFMq extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "mq";

	/**
	 * 
	 * @Title: getProducerQueue
	 * @Description:获取队列模式的生产者接口
	 * @return
	 */
	public JLFMqProducerQueue getProducerQueue();

	/**
	 * 
	 * @Title: JLFProducerTopic
	 * @Description:获取主题模式的生产者接口
	 * @return
	 */
	public JLFMqProducerTopic getProducerTopic();

	/**
	 * 
	 * @Title: getCousumerQueue
	 * @Description:获取队列模式的消费者接口
	 * @param process
	 * @return
	 */
	public <T extends Serializable> JLFMqCousumerQueue getCousumerQueue(JLFMqCousumerQueueProcess<T> process);

	/**
	 * 
	 * @Title: getCousumerTopic
	 * @Description:获取主题模式的消费者接口
	 * @param process
	 * @return
	 */
	public <T extends Serializable> JLFMqCousumerTopic getCousumerTopic(JLFMqCousumerTopicProcess<T> process);

}
