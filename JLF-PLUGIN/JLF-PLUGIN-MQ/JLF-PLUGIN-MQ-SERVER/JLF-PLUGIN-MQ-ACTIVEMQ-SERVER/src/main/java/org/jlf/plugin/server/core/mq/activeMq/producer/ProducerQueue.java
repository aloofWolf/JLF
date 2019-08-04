package org.jlf.plugin.server.core.mq.activeMq.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.mq.server.api.JLFMqProducerQueue;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqPool;

/**
 * 
 * @ClassName: ProducerQueue
 * @Description:����ģʽ������
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ProducerQueue extends Producer implements JLFMqProducerQueue {

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
