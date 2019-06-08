package org.jlf.plugin.push.wolf.test.socket.tool;

import org.jlf.plugin.push.user.api.JLFSignTool;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

public class SignTool implements JLFSignTool{

	@Override
	public String sign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception {
		return datagram+",sign=123";
	}

	@Override
	public boolean checkSign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
