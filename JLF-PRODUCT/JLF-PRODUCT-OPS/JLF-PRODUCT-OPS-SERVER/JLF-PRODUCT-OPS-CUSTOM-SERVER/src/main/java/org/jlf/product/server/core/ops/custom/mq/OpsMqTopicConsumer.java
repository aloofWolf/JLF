package org.jlf.product.server.core.ops.custom.mq;

import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;
import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.jlf.soa.mvc.container.ann.JLFMVCBean;

/**
 * 
 * @ClassName: OpsMqTopicConsumer
 * @Description:消息队列消费者
 * @author Lone Wolf
 * @date 2019年7月5日
 */

@JLFMVCBean
public class OpsMqTopicConsumer implements JLFMqCousumerTopicProcess<JLFOpsLog> {
	
	private boolean isStart = false; // 消费者是否启动

	@Override
	public String getTopicName() {
		return OpsMqTopicManager.getTopic();
	}

	@Override
	public JLFThreadPoolSubmit<JLFOpsLog> getThreadPoolSubmit() {
		return JLFMVCBeanContainer.get(OpsMqTopicConsumerProcess.class);
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	
	

}
