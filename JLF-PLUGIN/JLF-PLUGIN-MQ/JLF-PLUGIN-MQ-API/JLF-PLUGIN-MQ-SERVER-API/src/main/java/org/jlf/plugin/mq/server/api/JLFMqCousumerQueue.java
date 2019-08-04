package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFMqCousumerQueue
 * @Description:主题模式的消费者接口
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFMqCousumerQueue {

	/**
	 * 
	 * @Title: Listener
	 * @Description:开启监听
	 */
	public void start();

	/**
	 * 
	 * @Title: stop
	 * @Description:关闭监听
	 */
	public void stop();

}
