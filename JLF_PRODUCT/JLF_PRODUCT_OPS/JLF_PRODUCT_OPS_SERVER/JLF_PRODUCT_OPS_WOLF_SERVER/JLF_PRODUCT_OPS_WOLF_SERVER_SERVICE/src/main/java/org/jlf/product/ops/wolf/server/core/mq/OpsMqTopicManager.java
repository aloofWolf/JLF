package org.jlf.product.ops.wolf.server.core.mq;

/**
 * 
 * @ClassName: OpsMqTopicManager
 * @Description:OpsMqTopicManager
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsMqTopicManager {

	private static String hostCode; // 主机编号
	private static final String topic = "OPS";

	/**
	 * 
	 * @Title: init
	 * @Description:初始化配置
	 * @param config
	 */
	public static void init(String hostCode) {
		OpsMqTopicManager.hostCode = hostCode;
	}


	/**
	 * 
	 * @Title: getHostCode
	 * @Description:获取主机编号
	 * @return
	 */
	public static String getHostCode() {
		return hostCode;
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
