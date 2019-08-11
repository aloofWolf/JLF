package org.jlf.soa.mvc.dao.blacklist.mq;

import java.util.Date;

import org.jlf.plugin.client.mq.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFMqProducerTopic;

public class JLFMVCBlackListMqTopicProduct {
	
	private static final JLFMqProducerTopic topicProducer = JLFMqClient.get().getProducerTopic();

	public static void send(JLFMVCBlackListOperatorType type,String dbName,String tableName,Long id,Date expireTime) {
		JLFMVCBlackListBean bean = new JLFMVCBlackListBean();
		bean.setType(type);
		bean.setDbName(dbName);
		bean.setTableName(tableName);
		bean.setId(id);
		bean.setExpireTime(expireTime);
		topicProducer.send(JLFMVCBlackListMqTopicManager.getTopic(), bean);
	}

}
