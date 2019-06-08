package org.jlf.plugin.push.wolf.server.core;

import java.util.Map;

import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.push.server.api.JLFPush;
import org.jlf.plugin.push.user.api.JLFSendTool;
import org.jlf.plugin.push.user.api.config.JLFHttpConfig;
import org.jlf.plugin.push.user.api.config.JLFSocketConfig;
import org.jlf.plugin.push.user.api.config.JLFTransferConfig;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;
import org.jlf.plugin.push.wolf.server.core.send.http.HttpSend;
import org.jlf.plugin.push.wolf.server.core.send.socket.SocketSend;
import org.jlf.plugin.push.wolf.server.manager.ChannelManager;

public class PushWolfCore implements JLFPush{

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JLFPushRequest> JLFPushResponse send(String channelCode, String interCode, Map<String, Object> params) throws Exception {
		JLFInter<T,?,?> inter = (JLFInter<T, ?, ?>) ChannelManager.getInter(channelCode, interCode);
		if(inter == null){
			throw new Exception("根据渠道编号:"+channelCode+"和接口编号:"+interCode+"未能匹配到接口");
		}
		Class<T> reqCls = inter.getReqCls();
		T req = JLFCheckClient.get().check(params, reqCls);
		String datagram = inter.getDatagramTool().createDatagram(inter, req);
		String datagramSign = inter.getSignTool().sign(datagram, inter, req);
		String respDatagram = null;
		JLFSendTool sendTool = inter.getSendTool();
		if(sendTool != null){
			respDatagram = sendTool.send(inter, datagramSign);
		}else{
			JLFTransferConfig config = inter.getConfig(req);
			if(JLFSocketConfig.class.isAssignableFrom(config.getClass())){
				respDatagram = SocketSend.send((JLFSocketConfig) config, datagramSign);
			}else{
				respDatagram = HttpSend.send((JLFHttpConfig) config, datagramSign);
			}
		}
		return inter.getDatagramTool().createResponseBean(inter, respDatagram);
	}

}
