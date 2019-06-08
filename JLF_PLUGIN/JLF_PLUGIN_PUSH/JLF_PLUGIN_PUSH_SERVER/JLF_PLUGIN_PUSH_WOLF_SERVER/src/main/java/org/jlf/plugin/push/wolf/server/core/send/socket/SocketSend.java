package org.jlf.plugin.push.wolf.server.core.send.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.push.user.api.config.JLFSocketConfig;

/**
 * 
 * @ClassName: SocketSend
 * @Description:socket发送
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class SocketSend {

	/**
	 * 
	 * @Title: send
	 * @Description:socket发送
	 * @param config
	 * @param datagram
	 * @return
	 * @throws Exception
	 */
	public static String send(JLFSocketConfig config, String datagram) throws Exception {

		SocketExt socket = SocketPools.getSocket(config);

		String respXml = null;
		OutputStream os = null;
		PrintWriter pw = null;

		InputStream is = null;
		BufferedReader br = null;

		try {
			os = socket.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os, config.getCharset()));
			is = socket.getInputStream();

			br = new BufferedReader(new InputStreamReader(is, config.getCharset()));
			LogUtil.get().debug("send data is:" + datagram+"\\n");
			pw.write(datagram+"\n");
			pw.flush();
			//socket.shutdownOutput();
			String reply = null;
			respXml = "";
			while (!((reply = br.readLine()) == null)) {
				respXml += reply;
			}
			socket.shutdownInput();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			try {
				SocketPools.close(config, socket, br, is, pw, os);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return respXml;
	}

}
