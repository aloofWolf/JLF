package org.jlf.plugin.mq.activeMq.server.core.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFCousumerQueue;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;

/**
 * 
 * @ClassName: ConsumerQueue
 * @Description:队列模式的消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ConsumerQueue extends Consumer implements JLFCousumerQueue {

	private JLFCousumerQueueProcess process; // 实际消费者处理类
	private Class<? extends Serializable> messageCls; // 返回结果bean的class类型

	/**
	 * 
	 * 创建一个新的实例 ConsumerQueue.
	 *
	 * @param process
	 */
	public ConsumerQueue(JLFCousumerQueueProcess process) {
		this.process = process;
		this.messageCls = process.getMessageCls();
	}

	@Override
	public Destination getDestination(Session session) {
		try {
			return session.createQueue(getName());
		} catch (JMSException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	@Override
	public String getName() {
		return this.process.getQueueName();
	}

	@Override
	public void process(String result) {
		Serializable message = SerializeUtil.serializeToObject(result, this.messageCls);
		this.process.process(message);

	}

	@Override
	public Connection getConn() {
		return ActiveMqPool.getQueueConnection();
	}

}
