package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: JLFMqCousumerQueueProcess
 * @Description:队列模式的消费者的处理
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public interface JLFMqCousumerQueueProcess<T extends Serializable> {

	/**
	 * 
	 * @Title: getQueueName
	 * @Description:获取队列名称
	 * @return
	 */
	public String getQueueName();

	public JLFThreadPoolSubmit<T> getThreadPoolSubmit();

}
