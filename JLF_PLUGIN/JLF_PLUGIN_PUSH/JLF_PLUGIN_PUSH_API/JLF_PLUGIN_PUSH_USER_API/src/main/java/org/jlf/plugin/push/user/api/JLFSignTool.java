package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFSignTool
 * @Description:签名工具
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFSignTool {

	/**
	 * 
	 * @Title: sign
	 * @Description:对发送报文进行签名,得到签名后的报文数据
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String sign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

	/**
	 * 
	 * @Title: checkSign
	 * @Description:对返回报文进行验签
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public boolean checkSign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

}
