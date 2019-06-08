package org.jlf.plugin.mq.server.api;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: JLFMq
 * @Description:��Ϣ����api
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFMq extends JLFIPlugin{

	/**
	 * 
	 * @Title: getProducerQueue
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @return
	 */
	public JLFProducerQueue getProducerQueue();

	/**
	 * 
	 * @Title: JLFProducerTopic
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @return
	 */
	public JLFProducerTopic getProducerTopic();

	/**
	 * 
	 * @Title: getCousumerQueue
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @param process
	 * @return
	 * @throws Exception 
	 */
	public JLFCousumerQueue getCousumerQueue(JLFCousumerQueueProcess process) throws Exception;

	/**
	 * 
	 * @Title: getCousumerTopic
	 * @Description:��ȡ����ģʽ�������߽ӿ�
	 * @param process
	 * @return
	 */
	public JLFCousumerTopic getCousumerTopic(JLFCousumerTopicProcess process) throws Exception;

}
