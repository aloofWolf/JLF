package org.jlf.plugin.mq.activeMq.server.core.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFCousumerQueue;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;

/**
 * 
 * @ClassName: ConsumerQueue
 * @Description:����ģʽ��������
 * @author Lone Wolf
 * @date 2019��6��6��
 * @param <T>
 */
public class ConsumerQueue extends Consumer implements JLFCousumerQueue {

	private JLFCousumerQueueProcess process; // ʵ�������ߴ�����
	private Class<? extends Serializable> messageCls; // ���ؽ��bean��class����

	/**
	 * 
	 * ����һ���µ�ʵ�� ConsumerQueue.
	 *
	 * @param process
	 * @throws Exception
	 */
	public ConsumerQueue(JLFCousumerQueueProcess process) throws Exception {
		this.process = process;
		this.messageCls = process.getMessageCls();
	}

	@Override
	public Destination getDestination(Session session) throws Exception {
		return session.createQueue(getName());
	}

	@Override
	public String getName() {
		return this.process.getQueueName();
	}

	@Override
	public void process(String result) throws Exception {
		Serializable message = SerializeUtil.serializeToObject(result, this.messageCls);
		this.process.process(message);

	}

	@Override
	public Connection getConn() throws Exception {
		return ActiveMqPool.getQueueConnection();
	}

}
