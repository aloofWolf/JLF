package org.jlf.plugin.push.wolf.server.core.send.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

import org.jlf.plugin.push.user.api.config.JLFSocketConfig;

/**
 * 
 * @ClassName: SocketPools
 * @Description:socket连接池集合,每个ip加端口对应一个连接池
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class SocketPools {

	/**
	 * 连接池集合的map
	 */
	private static ConcurrentHashMap<String, SocketPool> pools = new ConcurrentHashMap<String, SocketPool>();

	/**
	 * 
	 * @Title: getSocket
	 * @Description:从连接池中取出一个socket
	 * @param config
	 * @return
	 * @throws Exception
	 */
	public static SocketExt getSocket(JLFSocketConfig config) throws Exception {
		String key = new StringBuffer(config.getIp()).append("_").append(config.getPort()).toString();
		SocketPool pool = pools.get(key);
		if (pool == null) {
			pool = new SocketPool(config);
			pools.put(key, pool);
		}
		return pool.getSocket();

	}

	/**
	 * 
	 * @Title: close
	 * @Description:关闭连接
	 * @param config
	 * @param conn
	 * @param br
	 * @param is
	 * @param pw
	 * @param os
	 * @throws Exception
	 */
	public static void close(JLFSocketConfig config, SocketExt conn, BufferedReader br, InputStream is, PrintWriter pw,
			OutputStream os) throws Exception {
		String key = new StringBuffer(config.getIp()).append("_").append(config.getPort()).toString();
		SocketPool pool = pools.get(key);
		pool.close(br, is, pw, os, conn);
	}

}
