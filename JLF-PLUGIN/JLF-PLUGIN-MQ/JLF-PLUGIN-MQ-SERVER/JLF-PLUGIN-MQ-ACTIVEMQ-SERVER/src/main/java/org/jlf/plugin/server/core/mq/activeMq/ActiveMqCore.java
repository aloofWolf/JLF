package org.jlf.plugin.server.core.mq.activeMq;

import java.io.Serializable;

import org.jlf.plugin.mq.server.api.JLFMq;
import org.jlf.plugin.mq.server.api.JLFMqCousumerQueue;
import org.jlf.plugin.mq.server.api.JLFMqCousumerTopic;
import org.jlf.plugin.mq.server.api.JLFMqProducerQueue;
import org.jlf.plugin.mq.server.api.JLFMqProducerTopic;
import org.jlf.plugin.mq.user.api.JLFMqCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;
import org.jlf.plugin.server.core.mq.activeMq.consumer.ConsumerQueue;
import org.jlf.plugin.server.core.mq.activeMq.consumer.ConsumerTopic;
import org.jlf.plugin.server.core.mq.activeMq.producer.ProducerQueue;
import org.jlf.plugin.server.core.mq.activeMq.producer.ProducerTopic;

/**
 * 
 * @ClassName: ActiveMqCore
 * @Description:ActiveMqCore
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class ActiveMqCore implements JLFMq {

	@Override
	public JLFMqProducerQueue getProducerQueue() {
		return ProducerQueue.getInstance();
	}

	@Override
	public JLFMqProducerTopic getProducerTopic() {
		return ProducerTopic.getInstance();
	}

	@Override
	public <T extends Serializable> JLFMqCousumerQueue getCousumerQueue(JLFMqCousumerQueueProcess<T> process) {
		return new ConsumerQueue<T>(process);
	}

	@Override
	public <T extends Serializable> JLFMqCousumerTopic getCousumerTopic(JLFMqCousumerTopicProcess<T> process) {
		return new ConsumerTopic<T>(process);
	}

}
