package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: JLFMqCousumerTopicProcess
 * @Description:主题模式的消费者的处理
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public interface JLFMqCousumerTopicProcess<T extends Serializable> {

	/**
	 * 
	 * @Title: getTopicName
	 * @Description:获取主题名称
	 * @return
	 */
	public String getTopicName();
	
	public JLFThreadPoolSubmit getThreadPoolSubmit();
}
