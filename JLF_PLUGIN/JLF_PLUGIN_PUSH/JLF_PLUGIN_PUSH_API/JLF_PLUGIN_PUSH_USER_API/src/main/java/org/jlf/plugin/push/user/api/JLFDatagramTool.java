package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFDatagramTool
 * @Description:报文工具
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFDatagramTool {

	/**
	 * 
	 * @Title: createDatagram
	 * @Description:将参数req封装成报文
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	public String createDatagram(JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

	/**
	 * 
	 * @Title: createResponseBean
	 * @Description:将返回报文封装成resp对象
	 * @param inter
	 * @param respDatagram
	 * @return
	 * @throws Exception 
	 */
	public JLFPushResponse createResponseBean(JLFInter<?, ?, ?> inter, String respDatagram) throws Exception;

}
