package org.jlf.plugin.push.test.http.tool;

import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: HttpSignTool
 * @Description:ǩ������
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class HttpSignTool implements JLFPushSignTool {

	@Override
	public String sign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return datagram;
	}

	@Override
	public boolean checkSign(String datagram, JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return true;
	}

}
