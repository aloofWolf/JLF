package org.jlf.plugin.mq.server.api;

/**
 * 
 * @ClassName: JLFCousumerQueue
 * @Description:主题模式的消费者接口
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFCousumerQueue {

	/**
	 * 
	 * @Title: Listener
	 * @Description:开启监听
	 * @throws Exception
	 */
	public void start() throws Exception;

	/**
	 * 
	 * @Title: stop
	 * @Description:关闭监听
	 * @throws Exception
	 */
	public void stop() throws Exception;

}
