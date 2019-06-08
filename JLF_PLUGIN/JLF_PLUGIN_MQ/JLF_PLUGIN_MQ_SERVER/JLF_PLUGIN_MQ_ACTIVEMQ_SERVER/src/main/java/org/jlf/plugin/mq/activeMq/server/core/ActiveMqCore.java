package org.jlf.plugin.mq.activeMq.server.core;

import org.jlf.plugin.mq.activeMq.server.core.consumer.ConsumerQueue;
import org.jlf.plugin.mq.activeMq.server.core.consumer.ConsumerTopic;
import org.jlf.plugin.mq.activeMq.server.core.producer.ProducerQueue;
import org.jlf.plugin.mq.activeMq.server.core.producer.ProducerTopic;
import org.jlf.plugin.mq.server.api.JLFCousumerQueue;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.plugin.mq.server.api.JLFMq;
import org.jlf.plugin.mq.server.api.JLFProducerQueue;
import org.jlf.plugin.mq.server.api.JLFProducerTopic;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: ActiveMqCore
 * @Description:ActiveMqCore
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class ActiveMqCore implements JLFMq {

	@Override
	public JLFProducerQueue getProducerQueue() {
		return ProducerQueue.getInstance();
	}

	@Override
	public JLFProducerTopic getProducerTopic() {
		return ProducerTopic.getInstance();
	}

	@Override
	public JLFCousumerQueue getCousumerQueue(JLFCousumerQueueProcess process) throws Exception {
		return new ConsumerQueue(process);
	}

	@Override
	public JLFCousumerTopic getCousumerTopic(JLFCousumerTopicProcess process) throws Exception {
		return new ConsumerTopic(process);
	}

}
