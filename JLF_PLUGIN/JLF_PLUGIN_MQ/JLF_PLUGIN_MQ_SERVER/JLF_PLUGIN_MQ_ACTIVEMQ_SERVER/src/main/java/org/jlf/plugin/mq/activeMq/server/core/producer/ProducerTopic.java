package org.jlf.plugin.mq.activeMq.server.core.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;

import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFProducerTopic;

/**
 * 
 * @ClassName: ProducerTopic
 * @Description:生产模式消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ProducerTopic extends Producer implements JLFProducerTopic {

	private static ProducerTopic INSTANCE = new ProducerTopic();

	public static ProducerTopic getInstance() {
		return INSTANCE;
	}

	@Override
	public Destination getDestination(Session session, String topicName) throws Exception {
		return session.createTopic(topicName);
	}

	@Override
	public Connection getConn() throws Exception {
		return ActiveMqPool.getTopicConnection();
	}

}