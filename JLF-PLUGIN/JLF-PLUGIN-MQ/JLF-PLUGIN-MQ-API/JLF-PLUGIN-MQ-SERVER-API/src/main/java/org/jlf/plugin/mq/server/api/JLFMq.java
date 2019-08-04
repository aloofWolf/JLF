package org.jlf.plugin.mq.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.mq.user.api.JLFMqCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;

/**
 * 
 * @ClassName: JLFMq
 * @Description:��Ϣ����api
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFMq extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "mq";

	/**
	 * 
	 * @Title: getProducerQueue
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @return
	 */
	public JLFMqProducerQueue getProducerQueue();

	/**
	 * 
	 * @Title: JLFProducerTopic
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @return
	 */
	public JLFMqProducerTopic getProducerTopic();

	/**
	 * 
	 * @Title: getCousumerQueue
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @param process
	 * @return
	 */
	public <T extends Serializable> JLFMqCousumerQueue getCousumerQueue(JLFMqCousumerQueueProcess<T> process);

	/**
	 * 
	 * @Title: getCousumerTopic
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @param process
	 * @return
	 */
	public <T extends Serializable> JLFMqCousumerTopic getCousumerTopic(JLFMqCousumerTopicProcess<T> process);

}
