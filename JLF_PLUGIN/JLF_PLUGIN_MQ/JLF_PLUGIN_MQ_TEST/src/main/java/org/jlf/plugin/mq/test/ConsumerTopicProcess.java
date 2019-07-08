package org.jlf.plugin.mq.test;

import java.io.Serializable;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;

/**
 * 
 * @ClassName: ConsumerTopicProcess
 * @Description:ConsumerTopicProcess
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class ConsumerTopicProcess implements JLFCousumerTopicProcess {

	@Override
	public String getTopicName() {
		return "TOPIC";
	}

	@Override
	public void process(Serializable obj) {
		Bean bean = (Bean) obj;
		LogUtil.get().debug(bean.toString());

	}

	@Override
	public Class<? extends Serializable> getMessageCls() {
		return Bean.class;
	}

}
