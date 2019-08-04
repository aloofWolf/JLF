package org.jlf.plugin.mq.test;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: ConsumerTopicProcess
 * @Description:ConsumerTopicProcess
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class ConsumerTopicProcess implements JLFMqCousumerTopicProcess<Bean> {

	@Override
	public String getTopicName() {
		return "TOPIC";
	}
	
	@Override
	public JLFThreadPoolSubmit getThreadPoolSubmit() {
		return new TopicSubmit();
	}
}

class TopicSubmit implements JLFThreadPoolSubmit{


	@SuppressWarnings("hiding")
	@Override
	public <Bean> void execute(Bean bean) throws Exception {
		LogUtil.get().debug(bean.toString());
		
	}
	
}
