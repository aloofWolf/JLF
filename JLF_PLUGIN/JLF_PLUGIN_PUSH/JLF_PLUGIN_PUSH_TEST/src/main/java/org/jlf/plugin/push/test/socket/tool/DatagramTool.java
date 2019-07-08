package org.jlf.plugin.push.test.socket.tool;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.push.test.socket.metadata.Response;
import org.jlf.plugin.push.user.api.JLFDatagramTool;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: DatagramTool
 * @Description:报文工具
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class DatagramTool implements JLFDatagramTool {

	@Override
	public String createDatagram(JLFInter<?, ?, ?> inter, JLFPushRequest req) {
		return JLFJsonClient.get().beanToJsonStr(req);
	}

	@Override
	public JLFPushResponse createResponseBean(JLFInter<?, ?, ?> inter, String respDatagram) {
		LogUtil.get().debug("respDatagram={}", respDatagram);
		return (JLFPushResponse) JLFJsonClient.get().jsonStrToBean(respDatagram, Response.class);
	}

}
