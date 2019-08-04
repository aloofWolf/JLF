package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: JLFMqCousumerTopicProcess
 * @Description:����ģʽ�������ߵĴ���
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public interface JLFMqCousumerTopicProcess<T extends Serializable> {

	/**
	 * 
	 * @Title: getTopicName
	 * @Description:��ȡ��������
	 * @return
	 */
	public String getTopicName();
	
	public JLFThreadPoolSubmit getThreadPoolSubmit();
}
