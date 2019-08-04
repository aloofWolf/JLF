package org.jlf.plugin.server.core.push.custom.send.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.push.user.api.config.JLFPushSocketConfig;

/**
 * 
 * @ClassName: SocketExt
 * @Description:socket扩展类
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class SocketExt extends Socket {

	private boolean preSocket; // socket是否是连接池预置的标识

	/**
	 * 
	 * 创建一个新的实例 SocketExt.
	 *
	 * @param config
	 * @param preSocket
	 */
	public SocketExt(JLFPushSocketConfig config, boolean preSocket) {
		super();
		try {
			this.connect(new InetSocketAddress(config.getIp(), config.getPort()), config.getConntimeout());
			this.setSoTimeout(config.getReadconntimeout());
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		this.preSocket = preSocket;
	}

	public boolean isPreSocket() {
		return preSocket;
	}

	public void setPreSocket(boolean preSocket) {
		this.preSocket = preSocket;
	}

}
