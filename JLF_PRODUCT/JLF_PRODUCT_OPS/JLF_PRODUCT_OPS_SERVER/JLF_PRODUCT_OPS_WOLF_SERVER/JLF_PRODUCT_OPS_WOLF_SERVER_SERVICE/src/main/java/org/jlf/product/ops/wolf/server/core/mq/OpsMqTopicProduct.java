package org.jlf.product.ops.wolf.server.core.mq;

import org.jlf.plugin.mq.client.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFProducerTopic;
import org.jlf.plugin.session.client.JLFSessionClient;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.ops.wolf.server.metadata.bean.OpsLog;

/**
 * 
 * @ClassName: OpsMqTopicProduct
 * @Description:OpsMq生产者
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsMqTopicProduct {

	private static final JLFProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();

	public static void send(JLFOpsModule module, JLFOpsType type, String clientCode, String serverCode) {
		JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
		OpsLog opsLog = new OpsLog();
		opsLog.setModule(module);
		opsLog.setType(type);
		opsLog.setHostCode(OpsMqTopicManager.getHostCode());
		opsLog.setClientCode(clientCode);
		opsLog.setServerCode(serverCode);
		opsLog.setCreateUserId(sessionBean.getUserId());
		opsLog.setUpdateUserId(sessionBean.getUserId());
		opsLog.setCreateUserName(sessionBean.getUserName());
		opsLog.setOpsResult(JLFOpsResult.SUCCESS);
		topicProducer.send(OpsMqTopicManager.getTopic(), opsLog);
	}

}
