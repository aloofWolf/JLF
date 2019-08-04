package org.jlf.plugin.mq.server.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFMqProducerQueue
 * @Description:����ģʽ�������߽ӿ�
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFMqProducerQueue {

	/**
	 * 
	 * @Title: send
	 * @Description:������Ϣ
	 * @param name
	 * @param obj
	 */
	public void send(String name, Serializable obj);

}
