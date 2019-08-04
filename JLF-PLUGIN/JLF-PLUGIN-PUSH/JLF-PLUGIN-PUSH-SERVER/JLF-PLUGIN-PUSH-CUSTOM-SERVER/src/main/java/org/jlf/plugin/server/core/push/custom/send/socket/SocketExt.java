package org.jlf.plugin.server.core.push.custom.send.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.push.user.api.config.JLFPushSocketConfig;

/**
 * 
 * @ClassName: SocketExt
 * @Description:socket��չ��
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class SocketExt extends Socket {

	private boolean preSocket; // socket�Ƿ������ӳ�Ԥ�õı�ʶ

	/**
	 * 
	 * ����һ���µ�ʵ�� SocketExt.
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
