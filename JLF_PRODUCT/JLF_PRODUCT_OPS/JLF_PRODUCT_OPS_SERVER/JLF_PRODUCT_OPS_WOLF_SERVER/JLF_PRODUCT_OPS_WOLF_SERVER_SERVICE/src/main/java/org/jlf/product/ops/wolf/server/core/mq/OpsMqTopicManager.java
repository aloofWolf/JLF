package org.jlf.product.ops.wolf.server.core.mq;

/**
 * 
 * @ClassName: OpsMqTopicManager
 * @Description:OpsMqTopicManager
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class OpsMqTopicManager {

	private static String hostCode; // �������
	private static final String topic = "OPS";

	/**
	 * 
	 * @Title: init
	 * @Description:��ʼ������
	 * @param config
	 */
	public static void init(String hostCode) {
		OpsMqTopicManager.hostCode = hostCode;
	}


	/**
	 * 
	 * @Title: getHostCode
	 * @Description:��ȡ�������
	 * @return
	 */
	public static String getHostCode() {
		return hostCode;
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
