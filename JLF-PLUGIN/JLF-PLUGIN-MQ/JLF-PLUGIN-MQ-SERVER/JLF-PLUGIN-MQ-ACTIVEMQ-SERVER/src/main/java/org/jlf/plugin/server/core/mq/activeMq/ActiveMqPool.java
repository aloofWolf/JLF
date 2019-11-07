package org.jlf.plugin.server.core.mq.activeMq;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.TopicConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.server.core.mq.activeMq.config.ActiveMqConfig;

/**
 * 
 * @ClassName: ActiveMqPool
 * @Description:activeMq���ӳ�
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ActiveMqPool {

	private static ActiveMQConnectionFactory factory = null;

	public static void init(ActiveMqConfig config) {
		factory = config.getFactory();
	}

	/**
	 * 
	 * @Title: getQueueConnection
	 * @Description:��ȡ���е�����
	 * @return
	 */
	public static QueueConnection getQueueConnection() {
		try {
			return factory.createQueueConnection();
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: getTopicConnection
	 * @Description:��ȡ���������
	 * @return
	 */
	public static TopicConnection getTopicConnection() {
		try {
			return factory.createTopicConnection();
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}
}
