package org.jlf.plugin.mq.activeMq.server.core.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: ConsumerTopic
 * @Description:����ģʽ��������
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ConsumerTopic extends Consumer implements JLFCousumerTopic {

	private JLFCousumerTopicProcess process; // ʵ�������ߴ�����
	private Class<? extends Serializable> messageCls; // ���ؽ��bean��class����

	/**
	 * 
	 * ����һ���µ�ʵ�� ConsumerQueue.
	 *
	 * @param process
	 * @
	 */
	public ConsumerTopic(JLFCousumerTopicProcess process) {
		this.process = process;
		this.messageCls = process.getMessageCls();
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
	public void process(String result) {
		Serializable message = SerializeUtil.serializeToObject(result, this.messageCls);
		try {
			this.process.process(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	@Override
	public Connection getConn() {
		return ActiveMqPool.getTopicConnection();
	}

}
