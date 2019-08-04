package org.jlf.plugin.push.test.socket.tool;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.push.test.socket.metadata.Response;
import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: DatagramTool
 * @Description:报文工具
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class DatagramTool implements JLFPushDatagramTool {

	@Override
	public String createDatagram(JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return JLFJsonClient.get().beanToJsonStr(req);
	}

	@Override
	public JLFPushResponse createResponseBean(JLFPushInter<?, ?, ?> inter, String respDatagram) {
		LogUtil.get().debug("respDatagram={}", respDatagram);
		return (JLFPushResponse) JLFJsonClient.get().jsonStrToBean(respDatagram, Response.class);
	}

}
