package org.jlf.plugin.push.wolf.test.socket.tool;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.push.user.api.JLFDatagramTool;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;
import org.jlf.plugin.push.wolf.test.socket.metadata.Response;

public class DatagramTool implements JLFDatagramTool{

	@Override
	public String createDatagram(JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception {
		return JLFJsonClient.get().beanToJsonStr(req);
	}

	@Override
	public JLFPushResponse createResponseBean(JLFInter<?, ?, ?> inter, String respDatagram) throws Exception {
		LogUtil.get().debug("respDatagram={}",respDatagram);
		return (JLFPushResponse) JLFJsonClient.get().jsonStrToBean(respDatagram, Response.class);
	}

}
