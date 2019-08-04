package org.jlf.plugin.mq.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.mq.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFMqCousumerQueue;
import org.jlf.plugin.mq.server.api.JLFMqCousumerTopic;
import org.jlf.plugin.mq.server.api.JLFMqProducerQueue;
import org.jlf.plugin.mq.server.api.JLFMqProducerTopic;

/**
 * 
 * @ClassName: MqTest
 * @Description:Mq≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ6‘¬6»’
 */
public class MqTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		JLFCore.starts();
		testQueue();
		testTopic();

	}

	/**
	 * 
	 * @Title: testQueue
	 * @Description:queue≤‚ ‘
	 * @throws Exception
	 */
	private static void testQueue() throws Exception {
		Bean bean1 = new Bean("qq", "22");
		Bean bean2 = new Bean("ww", "33");
		JLFMqProducerQueue queueProducer = JLFMqClient.get().getProducerQueue();
		queueProducer.send("QUEUE", bean1);
		queueProducer.send("QUEUE", bean2);
		JLFMqCousumerQueue queueConsumer = JLFMqClient.get().getCousumerQueue(new ConsumerQueueProcess());
		queueConsumer.start();
	}

	/**
	 * 
	 * @Title: testTopic
	 * @Description:topic≤‚ ‘
	 * @throws Exception
	 */
	private static void testTopic() throws Exception {
		Bean bean1 = new Bean("aa", "44");
		Bean bean2 = new Bean("dd", "66");
		JLFMqProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();
		JLFMqCousumerTopic topicConsumer = JLFMqClient.get().getCousumerTopic(new ConsumerTopicProcess());
		topicConsumer.start();
		topicProducer.send("TOPIC", bean1);
		topicProducer.send("TOPIC", bean2);

	}
}