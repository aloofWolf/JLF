package org.jlf.plugin.push.test.socket.config;

import org.jlf.plugin.push.user.api.config.JLFSocketConfig;

/**
 * 
 * @ClassName: SocketConfig
 * @Description:SocketChannel
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class SocketConfig extends JLFSocketConfig {

	private String ip;
	private Integer port;

	public SocketConfig(String ip, Integer port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public String getIp() {
		return this.ip;
	}

	@Override
	public Integer getPort() {
		return this.port;
	}

}
