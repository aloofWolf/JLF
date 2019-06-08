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
 * @Description:socket���ӳؼ���,ÿ��ip�Ӷ˿ڶ�Ӧһ�����ӳ�
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class SocketPools {

	/**
	 * ���ӳؼ��ϵ�map
	 */
	private static ConcurrentHashMap<String, SocketPool> pools = new ConcurrentHashMap<String, SocketPool>();

	/**
	 * 
	 * @Title: getSocket
	 * @Description:�����ӳ���ȡ��һ��socket
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
	 * @Description:�ر�����
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
