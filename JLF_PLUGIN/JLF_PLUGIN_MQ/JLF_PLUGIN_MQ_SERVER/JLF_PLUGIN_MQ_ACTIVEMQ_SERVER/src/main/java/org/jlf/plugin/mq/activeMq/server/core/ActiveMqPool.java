package org.jlf.plugin.mq.activeMq.server.core;

import javax.jms.QueueConnection;
import javax.jms.TopicConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.jlf.plugin.mq.activeMq.server.config.ActiveMqConfig;

/**
 * 
 * @ClassName: ActiveMqPool
 * @Description:activeMq连接池
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ActiveMqPool {

	private static ActiveMQConnectionFactory factory = null;

	public static void init(ActiveMqConfig config) throws Exception {
		factory = new ActiveMQConnectionFactory(config.getUrl());
		if (factory == null) {
			factory = new ActiveMQConnectionFactory();
		}
		factory.setBrokerURL(config.getUrl());
		factory.setUserName(config.getUserName());
		factory.setPassword(config.getPassword());
	}

	/**
	 * 
	 * @Title: getQueueConnection
	 * @Description:获取队列的连接
	 * @return
	 * @throws Exception
	 */
	public static QueueConnection getQueueConnection() throws Exception {
		return factory.createQueueConnection();
	}

	/**
	 * 
	 * @Title: getTopicConnection
	 * @Description:获取主题的连接
	 * @return
	 * @throws Exception
	 */
	public static TopicConnection getTopicConnection() throws Exception {
		return factory.createTopicConnection();
	}
}
