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
 * @Description:Socket�����
 * @author Lone Wolf
 * @date 2019��7��5��
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
		LogUtil.get().info("socket���������ɹ�");
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
						System.out.println("���Ƿ��������ͻ���˵:" + info);
					}
					socket.shutdownInput();
				} catch (IOException e) {
					e.printStackTrace();
					// LogUtil.get().debug("socket����ʧ��");
				}
				// LogUtil.get().debug("���߳̽�����");
				try {
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					pw.write("{'qq':'33','zz':'44'}\n");
					pw.flush();
					// �ر�������
					socket.shutdownOutput();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
