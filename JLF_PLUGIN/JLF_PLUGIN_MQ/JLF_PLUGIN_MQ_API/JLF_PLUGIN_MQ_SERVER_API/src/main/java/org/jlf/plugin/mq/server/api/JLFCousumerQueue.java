package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFCousumerQueue
 * @Description:����ģʽ�������߽ӿ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFCousumerQueue {

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
