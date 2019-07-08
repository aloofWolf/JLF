package org.jlf.plugin.mq.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.mq.client.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFCousumerQueue;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.plugin.mq.server.api.JLFProducerQueue;
import org.jlf.plugin.mq.server.api.JLFProducerTopic;

/**
 * 
 * @ClassName: MqTest
 * @Description:Mq≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ6‘¬6»’
 */
public class MqTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		MqTest server = new MqTest();
		server.starts();
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
		JLFProducerQueue queueProducer = JLFMqClient.get().getProducerQueue();
		queueProducer.send("QUEUE", bean1);
		queueProducer.send("QUEUE", bean2);
		JLFCousumerQueue queueConsumer = JLFMqClient.get().getCousumerQueue(new ConsumerQueueProcess());
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
		JLFProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();
		JLFCousumerTopic topicConsumer = JLFMqClient.get().getCousumerTopic(new ConsumerTopicProcess());
		topicConsumer.start();
		topicProducer.send("TOPIC", bean1);
		topicProducer.send("TOPIC", bean2);

	}
}