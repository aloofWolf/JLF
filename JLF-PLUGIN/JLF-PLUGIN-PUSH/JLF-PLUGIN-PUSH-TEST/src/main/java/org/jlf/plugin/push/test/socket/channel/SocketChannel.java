package org.jlf.plugin.push.test.socket.channel;

import java.util.Properties;

import org.jlf.plugin.push.server.api.JLFPushChannelAnn;
import org.jlf.plugin.push.test.socket.config.SocketConfig;
import org.jlf.plugin.push.test.socket.tool.DatagramTool;
import org.jlf.plugin.push.test.socket.tool.SignTool;
import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.channel.JLFPushChannel;

/**
 * 
 * @ClassName: SocketChannel
 * @Description:SocketChannel
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
@JLFPushChannelAnn(channelCode = "socket")
public class SocketChannel implements JLFPushChannel<SocketConfig> {

	private SocketConfig config;

	@Override
	public SocketConfig getConfig() {
		return this.config;
	}

	@Override
	public JLFPushDatagramTool getDatagramTool() {
		return new DatagramTool();
	}

	@Override
	public JLFPushSignTool getSignTool() {
		return new SignTool();
	}

	@Override
	public void initConfig(Properties props) {
		this.config = new SocketConfig((String) props.get("ip"), Integer.parseInt((String) props.get("port")));
	}

}
