package org.jlf.plugin.mq.activeMq.server.core.consumer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;

import org.jlf.common.util.SerializeUtil;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: ConsumerTopic
 * @Description:主题模式的消费者
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ConsumerTopic extends Consumer implements JLFCousumerTopic {

	private JLFCousumerTopicProcess process; // 实际消费者处理类
	private Class<? extends Serializable> messageCls; // 返回结果bean的class类型

	/**
	 * 
	 * 创建一个新的实例 ConsumerQueue.
	 *
	 * @param process
	 * @throws Exception
	 */
	public ConsumerTopic(JLFCousumerTopicProcess process) throws Exception {
		this.process = process;
		this.messageCls = process.getMessageCls();
	}

	@Override
	public Destination getDestination(Session session) throws Exception {
		return session.createTopic(getName());
	}

	@Override
	public String getName() {
		return this.process.getTopicName();
	}

	@Override
	public void process(String result) throws Exception {
		Serializable message = SerializeUtil.serializeToObject(result, this.messageCls);
		this.process.process(message);

	}

	@Override
	public Connection getConn() throws Exception {
		return ActiveMqPool.getTopicConnection();
	}

}
