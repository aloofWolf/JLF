package org.jlf.plugin.push.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: SocketServer
 * @Description:Socket服务端
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class SocketServer {

	public static void main(String[] args) throws IOException {
		SocketServer test = new SocketServer();
		test.startServer();
	}

	public void startServer() throws IOException {
		ServerSocket server = new ServerSocket(8081);
		SocketThread socketThread = new SocketThread(server);
		Thread t = new Thread(socketThread);
		t.start();
		LogUtil.get().info("socket监听启动成功");
	}

	class SocketThread implements Runnable {

		private ServerSocket server;

		public SocketThread(ServerSocket server) {
			this.server = server;
		}

		@Override
		public void run() {
			while (true) {
				Socket socket = null;
				InputStream is = null;
				InputStreamReader isr = null;
				BufferedReader br = null;
				OutputStream os = null;
				PrintWriter pw = null;
				try {
					socket = server.accept();
					is = socket.getInputStream();
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					String info = null;
					if ((info = br.readLine()) != null) {
						System.out.println("我是服务器，客户端说:" + info);
					}
					socket.shutdownInput();
				} catch (IOException e) {
					e.printStackTrace();
					// LogUtil.get().debug("socket接收失败");
				}
				// LogUtil.get().debug("有线程进来了");
				try {
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					pw.write("{'qq':'33','zz':'44'}\n");
					pw.flush();
					// 关闭输入流
					socket.shutdownOutput();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
