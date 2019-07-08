package org.jlf.plugin.push.wolf.server.core.send.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Vector;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.push.user.api.config.JLFSocketConfig;

/**
 * 
 * @ClassName: SocketPool
 * @Description:socket连接池
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class SocketPool {

	private JLFSocketConfig config; // socket配置信息

	public SocketPool(JLFSocketConfig config) {
		this.config = config;
	}

	private Vector<SocketExt> sockets = new Vector<SocketExt>(); // 预置的socket集合
	private Integer socketCount = 0; // 已经预置的socket数量

	/**
	 * 
	 * @Title: getConn
	 * @Description:从连接池内获取一个socket连接
	 * @return @
	 */
	public synchronized SocketExt getSocket() {
		int size = sockets.size();
		SocketExt conn = null;
		if (size > 0) {
			conn = sockets.get(size - 1);
			sockets.remove(size - 1);
		} else {
			boolean preSocket = false;
			if (socketCount < config.getMaxConnCount()) {
				preSocket = true;
				socketCount = socketCount + 1;
			}
			conn = new SocketExt(config, preSocket);
		}
		return conn;
	}

	/**
	 * 
	 * @Title: close
	 * @Description:关闭socket连接
	 * @param br
	 * @param is
	 * @param pw
	 * @param os
	 * @param socket
	 */
	public void close(BufferedReader br, InputStream is, PrintWriter pw, OutputStream os, SocketExt socket) {
		if (socket.isPreSocket()) {
			sockets.add(socket);
		} else {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new JLFException(e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new JLFException(e);
				}
			}
			if (pw != null) {
				pw.close();
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new JLFException(e);
				}
			}
		}
	}
}
