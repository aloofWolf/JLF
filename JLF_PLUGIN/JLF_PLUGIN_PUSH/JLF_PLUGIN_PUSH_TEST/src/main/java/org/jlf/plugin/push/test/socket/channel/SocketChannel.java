package org.jlf.plugin.push.test.socket.channel;

import java.util.Properties;

import org.jlf.plugin.push.server.api.JLFChannelAnn;
import org.jlf.plugin.push.test.socket.config.SocketConfig;
import org.jlf.plugin.push.test.socket.tool.DatagramTool;
import org.jlf.plugin.push.test.socket.tool.SignTool;
import org.jlf.plugin.push.user.api.JLFDatagramTool;
import org.jlf.plugin.push.user.api.JLFSignTool;
import org.jlf.plugin.push.user.api.channel.JLFChannel;

/**
 * 
 * @ClassName: SocketChannel
 * @Description:SocketChannel
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFChannelAnn(channelCode = "socket")
public class SocketChannel implements JLFChannel<SocketConfig> {

	private SocketConfig config;

	@Override
	public SocketConfig getConfig() {
		return this.config;
	}

	@Override
	public JLFDatagramTool getDatagramTool() {
		return new DatagramTool();
	}

	@Override
	public JLFSignTool getSignTool() {
		return new SignTool();
	}

	@Override
	public void initConfig(Properties props) {
		this.config = new SocketConfig((String) props.get("ip"), Integer.parseInt((String) props.get("port")));
	}

}