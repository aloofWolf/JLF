package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: JLFMqCousumerQueueProcess
 * @Description:����ģʽ�������ߵĴ���
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public interface JLFMqCousumerQueueProcess<T extends Serializable> {

	/**
	 * 
	 * @Title: getQueueName
	 * @Description:��ȡ��������
	 * @return
	 */
	public String getQueueName();

	public JLFThreadPoolSubmit<T> getThreadPoolSubmit();

}
