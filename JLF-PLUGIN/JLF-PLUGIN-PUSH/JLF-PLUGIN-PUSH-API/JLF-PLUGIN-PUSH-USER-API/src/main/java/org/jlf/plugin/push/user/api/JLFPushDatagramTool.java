package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFPushDatagramTool
 * @Description:报文工具
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFPushDatagramTool {

	/**
	 * 
	 * @Title: createDatagram
	 * @Description:将参数req封装成报文
	 * @param inter
	 * @param req
	 * @return
	 */
	public String createDatagram(JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

	/**
	 * 
	 * @Title: createResponseBean
	 * @Description:将返回报文封装成resp对象
	 * @param inter
	 * @param respDatagram
	 * @return
	 */
	public JLFPushResponse createResponseBean(JLFPushInter<?, ?, ?> inter, String respDatagram);

}
