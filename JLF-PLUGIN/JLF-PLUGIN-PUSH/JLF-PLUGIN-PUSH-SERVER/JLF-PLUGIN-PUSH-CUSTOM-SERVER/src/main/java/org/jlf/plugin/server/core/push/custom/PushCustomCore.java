package org.jlf.plugin.server.core.push.custom;

import java.util.Map;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.push.server.api.JLFPush;
import org.jlf.plugin.push.user.api.JLFPushSendTool;
import org.jlf.plugin.push.user.api.config.JLFPushHttpConfig;
import org.jlf.plugin.push.user.api.config.JLFPushSocketConfig;
import org.jlf.plugin.push.user.api.config.JLFPushTransferConfig;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;
import org.jlf.plugin.server.core.push.custom.manager.ChannelManager;
import org.jlf.plugin.server.core.push.custom.send.http.HttpSend;
import org.jlf.plugin.server.core.push.custom.send.socket.SocketSend;

/**
 * 
 * @ClassName: PushWolfCore
 * @Description:PushWolfCore
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class PushCustomCore implements JLFPush {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JLFPushRequest> JLFPushResponse send(String channelCode, String interCode,
			Map<String, Object> params) {
		JLFPushInter<T, ?, ?> inter = (JLFPushInter<T, ?, ?>) ChannelManager.getInter(channelCode, interCode);
		if (inter == null) {
			throw new JLFException("根据渠道编号:" + channelCode + "和接口编号:" + interCode + "未能匹配到接口");
		}
		Class<T> reqCls = inter.getReqCls();
		T req = JLFCheckClient.get().check(params, reqCls);
		String datagram = inter.getDatagramTool().createDatagram(inter, req);
		String datagramSign = inter.getSignTool().sign(datagram, inter, req);
		String respDatagram = null;
		JLFPushSendTool sendTool = inter.getSendTool();
		if (sendTool != null) {
			respDatagram = sendTool.send(inter, datagramSign);
		} else {
			JLFPushTransferConfig config = inter.getConfig(req);
			if (JLFPushSocketConfig.class.isAssignableFrom(config.getClass())) {
				respDatagram = SocketSend.send((JLFPushSocketConfig) config, datagramSign);
			} else {
				respDatagram = HttpSend.send((JLFPushHttpConfig) config, datagramSign);
			}
		}
		return inter.getDatagramTool().createResponseBean(inter, respDatagram);
	}

}
