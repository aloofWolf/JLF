package org.jlf.plugin.mq.activeMq.server.core.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;

import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFProducerQueue;

/**
 * 
 * @ClassName: ProducerQueue
 * @Description:����ģʽ������
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ProducerQueue extends Producer implements JLFProducerQueue {

	private static ProducerQueue INSTANCE = new ProducerQueue();

	public static ProducerQueue getInstance() {
		return INSTANCE;
	}

	@Override
	public Destination getDestination(Session session, String queueName) throws Exception {
		return session.createQueue(queueName);
	}

	@Override
	public Connection getConn() throws Exception {
		return ActiveMqPool.getQueueConnection();
	}

}
