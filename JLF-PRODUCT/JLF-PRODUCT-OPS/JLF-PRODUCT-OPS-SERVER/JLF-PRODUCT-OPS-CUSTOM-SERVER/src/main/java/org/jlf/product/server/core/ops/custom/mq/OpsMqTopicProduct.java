package org.jlf.product.server.core.ops.custom.mq;

import org.jlf.plugin.client.mq.JLFMqClient;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.mq.server.api.JLFMqProducerTopic;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;

/**
 * 
 * @ClassName: OpsMqTopicProduct
 * @Description:OpsMq生产者
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsMqTopicProduct {

	private static final JLFMqProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();

	public static void send(JLFOpsModule module, JLFOpsType type, String clientClsName, String serverClsName) {
		JLFSessionBean sessionBean = JLFSessionClient.get().getSessionBean();
		JLFOpsLog opsLog = new JLFOpsLog();
		opsLog.setModule(module);
		opsLog.setType(type);
		opsLog.setHostIp(OpsMqTopicManager.getHostIp());
		opsLog.setClientClsName(clientClsName);
		opsLog.setServerClsName(serverClsName);
		opsLog.setCreateUserId(sessionBean.getUserId());
		opsLog.setUpdateUserId(sessionBean.getUserId());
		opsLog.setCreateUserName(sessionBean.getUserName());
		opsLog.setOpsResult(JLFOpsResult.SUCCESS);
		topicProducer.send(OpsMqTopicManager.getTopic(), opsLog);
	}

}
