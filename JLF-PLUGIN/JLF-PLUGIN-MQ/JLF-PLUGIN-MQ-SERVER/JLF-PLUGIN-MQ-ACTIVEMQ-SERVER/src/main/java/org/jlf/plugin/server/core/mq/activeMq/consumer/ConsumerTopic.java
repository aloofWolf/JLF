package org.jlf.plugin.server.core.mq.activeMq.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.mq.server.api.JLFMqCousumerTopic;
import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqPool;

/**
 * 
 * @ClassName: ConsumerTopic
 * @Description:主题模式的消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ConsumerTopic<T extends Serializable> extends Consumer<T> implements JLFMqCousumerTopic {

	private JLFMqCousumerTopicProcess<T> process; // 实际消费者处理类

	/**
	 * 
	 * 创建一个新的实例 ConsumerQueue.
	 *
	 * @param process
	 * @
	 */
	public ConsumerTopic(JLFMqCousumerTopicProcess<T> process) {
		super(process.getThreadPoolSubmit());
		this.process = process;
	}

	@Override
	public Destination getDestination(Session session) {
		try {
			return session.createTopic(getName());
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	@Override
	public String getName() {
		return this.process.getTopicName();
	}

	@Override
	public Connection getConn() {
		return ActiveMqPool.getTopicConnection();
	}

}
