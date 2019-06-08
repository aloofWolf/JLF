package org.jlf.plugin.push.wolf.test.socket.inter;

import org.jlf.plugin.push.server.api.JLFInterAnn;
import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.wolf.test.socket.channel.SocketChannel;
import org.jlf.plugin.push.wolf.test.socket.config.SocketConfig;
import org.jlf.plugin.push.wolf.test.socket.metadata.Request;

@JLFInterAnn(channelCode="socket",interCode="inter1")
public class Inter1 extends JLFInter<Request,SocketConfig,SocketChannel>{

	public Inter1(SocketChannel channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Request> getReqCls() {
		return Request.class;
	}

	
}
