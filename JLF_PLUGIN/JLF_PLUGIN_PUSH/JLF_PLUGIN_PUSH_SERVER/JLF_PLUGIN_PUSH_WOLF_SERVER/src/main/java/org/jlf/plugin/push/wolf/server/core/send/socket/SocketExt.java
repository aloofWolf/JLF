package org.jlf.plugin.push.wolf.server.core.send.socket;

import java.net.InetSocketAddress;
import java.net.Socket;

import org.jlf.plugin.push.user.api.config.JLFSocketConfig;

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
	 * @throws Exception
	 */
	public SocketExt(JLFSocketConfig config, boolean preSocket) throws Exception {
		super();
		this.connect(new InetSocketAddress(config.getIp(), config.getPort()), config.getConntimeout());
		this.setSoTimeout(config.getReadconntimeout());
		this.preSocket = preSocket;
	}

	public boolean isPreSocket() {
		return preSocket;
	}

	public void setPreSocket(boolean preSocket) {
		this.preSocket = preSocket;
	}

}
