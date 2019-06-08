package org.jlf.plugin.mq.user.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFCousumerTopicProcess
 * @Description:主题模式的消费者的处理
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public interface JLFCousumerTopicProcess {

	/**
	 * 
	 * @Title: getTopicName
	 * @Description:获取主题名称
	 * @return
	 */
	public String getTopicName();

	/**
	 * 
	 * @Title: getResultCls
	 * @Description:获取接收到的信息的bean的class类型
	 * @return
	 */
	public Class<? extends Serializable> getMessageCls();

	/**
	 * 
	 * @Title: process
	 * @Description:消费者接收消息后的处理
	 * @param obj
	 * @throws Exception
	 */
	public void process(Serializable obj) throws Exception;
}
