package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFMqCousumerTopic
 * @Description:����ģʽ�������߽ӿ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFMqCousumerTopic {

	/**
	 * 
	 * @Title: Listener
	 * @Description:��������
	 */
	public void start();

	/**
	 * 
	 * @Title: Listener
	 * @Description:�رռ���
	 */
	public void stop();

}
