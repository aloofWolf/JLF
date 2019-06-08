package org.jlf.plugin.mq.activeMq.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;
import org.jlf.plugin.mq.activeMq.server.ActiveMqServer;
import org.jlf.plugin.mq.client.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFCousumerQueue;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.plugin.mq.server.api.JLFProducerQueue;
import org.jlf.plugin.mq.server.api.JLFProducerTopic;

/**
 * 
    * @ClassName: ActiveMqTest
    * @Description:activeMq≤‚ ‘
    * @author Lone Wolf
    * @date 2019ƒÍ6‘¬6»’
 */
public class ActiveMqTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		ActiveMqTest server = new ActiveMqTest();
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
	private static void testQueue() throws Exception{
		Bean bean1 = new Bean("qq","22");
		Bean bean2 = new Bean("ww","33");
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
	private static void testTopic() throws Exception{
		Bean bean1 = new Bean("aa","44");
		Bean bean2 = new Bean("dd","66");
		JLFProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();
		JLFCousumerTopic topicConsumer = JLFMqClient.get().getCousumerTopic(new ConsumerTopicProcess());
		topicConsumer.start();
		topicProducer.send("TOPIC", bean1);
		topicProducer.send("TOPIC", bean2);
		
	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {	
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		plugins.add(new JLFJsonClient(new FastJsonServer()));
		plugins.add(new JLFMqClient(new ActiveMqServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}
}