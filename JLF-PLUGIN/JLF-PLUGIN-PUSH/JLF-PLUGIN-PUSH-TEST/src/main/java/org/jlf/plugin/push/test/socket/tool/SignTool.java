package org.jlf.plugin.push.test.socket.tool;

import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: SignTool
 * @Description:签名工具
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class SignTool implements JLFPushSignTool {

	@Override
	public String sign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return datagram + ",sign=123";
	}

	@Override
	public boolean checkSign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return true;
	}

}
