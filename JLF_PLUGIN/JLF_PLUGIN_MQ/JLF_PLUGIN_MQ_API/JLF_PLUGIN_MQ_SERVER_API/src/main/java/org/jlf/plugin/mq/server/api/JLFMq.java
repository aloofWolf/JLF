package org.jlf.plugin.mq.server.api;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: JLFMq
 * @Description:消息队列api
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFMq extends JLFPluginServerApi {

	/**
	 * 
	 * @Title: getProducerQueue
	 * @Description:获取队列模式的生产者接口
	 * @return
	 */
	public JLFProducerQueue getProducerQueue();

	/**
	 * 
	 * @Title: JLFProducerTopic
	 * @Description:获取主题模式的生产者接口
	 * @return
	 */
	public JLFProducerTopic getProducerTopic();

	/**
	 * 
	 * @Title: getCousumerQueue
	 * @Description:获取队列模式的消费者接口
	 * @param process
	 * @return
	 */
	public JLFCousumerQueue getCousumerQueue(JLFCousumerQueueProcess process);

	/**
	 * 
	 * @Title: getCousumerTopic
	 * @Description:获取主题模式的消费者接口
	 * @param process
	 * @return
	 */
	public JLFCousumerTopic getCousumerTopic(JLFCousumerTopicProcess process);

}
