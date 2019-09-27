package org.jlf.product.server.core.ops.custom.mq;

import org.jlf.common.util.HostUtil;

/**
 * 
 * @ClassName: OpsMqTopicManager
 * @Description:OpsMqTopicManager
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class OpsMqTopicManager {

	private static String hostIp = HostUtil.getCurrHostIp(); // ����ip
	private static final String topic = "OPS";


	/**
	 * 
	 * @Title: getHostCode
	 * @Description:��ȡ����ip
	 * @return
	 */
	public static String getHostIp() {
		return hostIp;
	}

	/**
	 * 
	 * @Title: getTopic
	 * @Description:��ȡtopic
	 * @return
	 */
	public static String getTopic() {
		return topic;
	}

}
