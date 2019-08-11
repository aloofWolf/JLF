package org.jlf.plugin.mq.test;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFMqCousumerQueueProcess;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: ConsumerQueueProcess
 * @Description:ConsumerQueueProcess
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class ConsumerQueueProcess implements JLFMqCousumerQueueProcess<Bean> {

	@Override
	public String getQueueName() {
		return "QUEUE";
	}
	
	@Override
	public JLFThreadPoolSubmit<Bean> getThreadPoolSubmit() {
		return new QueueSubmit();
	}
}

class QueueSubmit implements JLFThreadPoolSubmit<Bean>{


	@Override
	public void execute(Bean bean) throws Exception {
		LogUtil.get().debug(bean.toString());
		
	}
	
}


