package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;

/**
 * 
 * @ClassName: JLFSendTool
 * @Description:发送工具,如果调用者实现此接口,则采用此接口发送数据,如未实现,则采用socket或http发送
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFSendTool {

	/**
	 * 
	 * @Title: send
	 * @Description:发送数据方法
	 * @param inter
	 * @param datagram
	 * @return
	 * @throws Exception
	 */
	public String send(JLFInter<?, ?, ?> inter, String datagram) throws Exception;

}
