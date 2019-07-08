package org.jlf.plugin.push.test.socket.tool;

import org.jlf.plugin.push.user.api.JLFSignTool;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: SignTool
 * @Description:ǩ������
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class SignTool implements JLFSignTool {

	@Override
	public String sign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) {
		return datagram + ",sign=123";
	}

	@Override
	public boolean checkSign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) {
		return true;
	}

}
