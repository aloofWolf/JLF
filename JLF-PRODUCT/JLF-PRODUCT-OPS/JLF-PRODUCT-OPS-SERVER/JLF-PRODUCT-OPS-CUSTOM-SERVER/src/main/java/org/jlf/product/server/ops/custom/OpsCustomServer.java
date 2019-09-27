package org.jlf.product.server.ops.custom;

import org.jlf.core.server.JLFProductServer;
import org.jlf.plugin.client.mq.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFMqCousumerTopic;
import org.jlf.product.ops.server.api.JLFOps;
import org.jlf.product.server.core.ops.custom.mq.OpsMqTopicConsumer;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;

/**
 * 
 * @ClassName: OpsWolfServer
 * @Description:OpsWolfServer
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class OpsCustomServer extends JLFProductServer<JLFOps> {

	@Override
	public JLFOps getServerApi() {
		return JLFMVCBeanContainer.get(OpsCustomCore.class);
	}

	@Override
	public void start() {
		OpsMqTopicConsumer consumer = JLFMVCBeanContainer.get(OpsMqTopicConsumer.class);
		if (!consumer.isStart()) { // 重新启动时,无需启动消费者监听
			JLFMqCousumerTopic opsTopic = JLFMqClient.get().getCousumerTopic(consumer);
			opsTopic.start();
			consumer.setStart(true);
		}

	}
}
