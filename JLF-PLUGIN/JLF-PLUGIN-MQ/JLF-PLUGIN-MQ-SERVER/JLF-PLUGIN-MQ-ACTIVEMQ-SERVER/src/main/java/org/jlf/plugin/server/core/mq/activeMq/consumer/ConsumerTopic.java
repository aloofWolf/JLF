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
 * @Description:����ģʽ��������
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ConsumerTopic<T extends Serializable> extends Consumer<T> implements JLFMqCousumerTopic {

	private JLFMqCousumerTopicProcess<T> process; // ʵ�������ߴ�����

	/**
	 * 
	 * ����һ���µ�ʵ�� ConsumerQueue.
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
