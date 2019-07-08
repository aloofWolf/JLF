package org.jlf.plugin.push.test.socket.inter;

import org.jlf.plugin.push.server.api.JLFInterAnn;
import org.jlf.plugin.push.test.socket.channel.SocketChannel;
import org.jlf.plugin.push.test.socket.config.SocketConfig;
import org.jlf.plugin.push.test.socket.metadata.Request;
import org.jlf.plugin.push.user.api.inter.JLFInter;

/**
 * 
 * @ClassName: Inter1
 * @Description:渠道接口1
 * @author Lone Wolf
 * @date 2019年7月5日
 */
@JLFInterAnn(channelCode = "socket", interCode = "inter1")
public class Inter1 extends JLFInter<Request, SocketConfig, SocketChannel> {

	public Inter1(SocketChannel channel) {
		super(channel);
	}

	@Override
	public Class<Request> getReqCls() {
		return Request.class;
	}

}
