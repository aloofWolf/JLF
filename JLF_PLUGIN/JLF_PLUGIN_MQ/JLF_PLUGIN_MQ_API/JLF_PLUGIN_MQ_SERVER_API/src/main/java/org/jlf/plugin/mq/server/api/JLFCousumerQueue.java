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
	 * @throws Exception
	 */
	public void start() throws Exception;

	/**
	 * 
	 * @Title: stop
	 * @Description:�رռ���
	 * @throws Exception
	 */
	public void stop() throws Exception;

}
