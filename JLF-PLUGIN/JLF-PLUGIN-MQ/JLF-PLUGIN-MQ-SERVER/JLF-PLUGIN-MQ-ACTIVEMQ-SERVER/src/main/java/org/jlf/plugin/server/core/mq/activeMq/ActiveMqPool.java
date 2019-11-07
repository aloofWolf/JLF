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
 * @Description:activeMq连接池
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ActiveMqPool {

	private static ActiveMQConnectionFactory factory = null;

	public static void init(ActiveMqConfig config) {
		factory = config.getFactory();
	}

	/**
	 * 
	 * @Title: getQueueConnection
	 * @Description:获取队列的连接
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
	 * @Description:获取主题的连接
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
