package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFCousumerTopic
 * @Description:����ģʽ�������߽ӿ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFCousumerTopic {

	/**
	 * 
	 * @Title: Listener
	 * @Description:��������
	 * @throws Exception
	 */
	public void start() throws Exception;

	/**
	 * 
	 * @Title: Listener
	 * @Description:�رռ���
	 * @throws Exception
	 */
	public void stop() throws Exception;

}
