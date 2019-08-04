package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFPushSignTool
 * @Description:签名工具
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFPushSignTool {

	/**
	 * 
	 * @Title: sign
	 * @Description:对发送报文进行签名,得到签名后的报文数据
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 */
	public String sign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

	/**
	 * 
	 * @Title: checkSign
	 * @Description:对返回报文进行验签
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 */
	public boolean checkSign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

}
