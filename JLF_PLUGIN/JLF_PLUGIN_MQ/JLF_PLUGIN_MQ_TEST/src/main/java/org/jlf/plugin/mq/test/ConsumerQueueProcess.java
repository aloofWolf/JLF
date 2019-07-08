package org.jlf.plugin.mq.test;

import java.io.Serializable;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFCousumerQueueProcess;

/**
 * 
 * @ClassName: ConsumerQueueProcess
 * @Description:ConsumerQueueProcess
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class ConsumerQueueProcess implements JLFCousumerQueueProcess {

	@Override
	public String getQueueName() {
		return "QUEUE";
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
