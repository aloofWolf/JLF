package org.jlf.plugin.server.core.mq.activeMq.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.mq.server.api.JLFMqProducerTopic;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqPool;

/**
 * 
 * @ClassName: ProducerTopic
 * @Description:生产模式消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ProducerTopic extends Producer implements JLFMqProducerTopic {

	private static ProducerTopic INSTANCE = new ProducerTopic();

	public static ProducerTopic getInstance() {
		return INSTANCE;
	}

	@Override
	public Destination getDestination(Session session, String topicName) {
		try {
			return session.createTopic(topicName);
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	@Override
	public Connection getConn() {
		return ActiveMqPool.getTopicConnection();
	}

}