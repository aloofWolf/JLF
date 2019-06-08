package org.jlf.plugin.mq.activeMq.test;

import java.io.Serializable;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;

public class ConsumerQueueProcess implements JLFCousumerQueueProcess{

	@Override
	public String getQueueName() {
		return "QUEUE";
	}

	@Override
	public void process(Serializable obj) throws Exception {
		Bean bean = (Bean) obj;
		LogUtil.get().debug(bean.toString());
		
	}

	@Override
	public Class<? extends Serializable> getMessageCls() {
		return Bean.class;
	}

}
