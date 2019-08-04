package org.jlf.plugin.push.test.socket.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.socket.channel.SocketChannel;
import org.jlf.plugin.push.test.socket.config.SocketConfig;
import org.jlf.plugin.push.test.socket.metadata.Request;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

/**
 * 
 * @ClassName: Inter1
 * @Description:�����ӿ�1
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFPushInterAnn(channelCode = "socket", interCode = "inter1")
public class Inter1 extends JLFPushInter<Request, SocketConfig, SocketChannel> {

	public Inter1(SocketChannel channel) {
		super(channel);
	}

	@Override
	public Class<Request> getReqCls() {
		return Request.class;
	}

}
