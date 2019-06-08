package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFCousumerQueueProcess
 * @Description:����ģʽ�������ߵĴ���
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public interface JLFCousumerQueueProcess{

	/**
	 * 
	 * @Title: getQueueName
	 * @Description:��ȡ��������
	 * @return
	 */
	public String getQueueName();

	/**
	 * 
	 * @Title: getResultCls
	 * @Description:��ȡ���յ�����Ϣ��bean��class����
	 * @return
	 */
	public Class<? extends Serializable> getMessageCls();

	/**
	 * 
	 * @Title: process
	 * @Description:�����߽�����Ϣ��Ĵ���
	 * @param obj
	 * @throws Exception
	 */
	public void process(Serializable obj) throws Exception;

}
