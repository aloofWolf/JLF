package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFMqCousumerQueue
 * @Description:����ģʽ�������߽ӿ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFMqCousumerQueue {

	/**
	 * 
	 * @Title: Listener
	 * @Description:��������
	 */
	public void start();

	/**
	 * 
	 * @Title: stop
	 * @Description:�رռ���
	 */
	public void stop();

}
