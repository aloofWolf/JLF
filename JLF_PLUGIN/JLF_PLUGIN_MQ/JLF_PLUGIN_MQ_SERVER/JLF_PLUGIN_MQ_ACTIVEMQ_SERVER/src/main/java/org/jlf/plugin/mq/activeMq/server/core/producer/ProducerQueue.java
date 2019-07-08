package org.jlf.plugin.mq.activeMq.server.core.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFProducerQueue;

/**
 * 
 * @ClassName: ProducerQueue
 * @Description:队列模式消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ProducerQueue extends Producer implements JLFProducerQueue {

	private static ProducerQueue INSTANCE = new ProducerQueue();

	public static ProducerQueue getInstance() {
		return INSTANCE;
	}

	@Override
	public Destination getDestination(Session session, String queueName) {
		try {
			return session.createQueue(queueName);
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	@Override
	public Connection getConn() {
		return ActiveMqPool.getQueueConnection();
	}

}
