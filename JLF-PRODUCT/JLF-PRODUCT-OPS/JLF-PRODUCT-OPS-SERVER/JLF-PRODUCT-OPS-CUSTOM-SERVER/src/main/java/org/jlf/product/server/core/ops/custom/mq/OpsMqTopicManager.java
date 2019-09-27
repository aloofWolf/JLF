package org.jlf.product.server.core.ops.custom.mq;

import org.jlf.common.util.HostUtil;

/**
 * 
 * @ClassName: OpsMqTopicManager
 * @Description:OpsMqTopicManager
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsMqTopicManager {

	private static String hostIp = HostUtil.getCurrHostIp(); // 主机ip
	private static final String topic = "OPS";


	/**
	 * 
	 * @Title: getHostCode
	 * @Description:获取主机ip
	 * @return
	 */
	public static String getHostIp() {
		return hostIp;
	}

	/**
	 * 
	 * @Title: getTopic
	 * @Description:获取topic
	 * @return
	 */
	public static String getTopic() {
		return topic;
	}

}
