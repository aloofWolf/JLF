package org.jlf.plugin.mq.activeMq.test;

import java.io.Serializable;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

public class ConsumerTopicProcess implements JLFCousumerTopicProcess{

	@Override
	public String getTopicName() {
		return "TOPIC";
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
