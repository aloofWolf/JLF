package org.jlf.plugin.dbpool.wolf.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;
import org.jlf.plugin.dbpool.wolf.server.DbPoolWolfServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;

/**
 * 
 * @ClassName: DbWolfTest
 * @Description:DbWolf����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class DbPoolWolfTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:���Զ��߳���,ȡ��conn�Ƿ��̰߳�ȫ������ͨ��
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DbPoolWolfTest server = new DbPoolWolfTest();
		server.starts();
		ConnTest test1 = server.new ConnTest();
		ConnTest test2 = server.new ConnTest();
		ConnTest test3 = server.new ConnTest();
		ConnTest test4 = server.new ConnTest();
		ConnTest test5 = server.new ConnTest();
		ConnTest test6 = server.new ConnTest();
		ConnTest test7 = server.new ConnTest();
		ConnTest test8 = server.new ConnTest();
		ConnTest test9 = server.new ConnTest();
		ConnTest test10 = server.new ConnTest();

		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test2);
		Thread t3 = new Thread(test3);
		Thread t4 = new Thread(test4);
		Thread t5 = new Thread(test5);
		Thread t6 = new Thread(test6);
		Thread t7 = new Thread(test7);
		Thread t8 = new Thread(test8);
		Thread t9 = new Thread(test9);
		Thread t10 = new Thread(test10);

		t1.setName("�߳�1");
		t2.setName("�߳�2");
		t3.setName("�߳�3");
		t4.setName("�߳�4");
		t5.setName("�߳�5");
		t6.setName("�߳�6");
		t7.setName("�߳�7");
		t8.setName("�߳�8");
		t9.setName("�߳�9");
		t10.setName("�߳�10");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}

	class ConnTest implements Runnable {

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			try {
				String threadName = Thread.currentThread().getName();
				if (threadName.equals("�߳�4") || threadName.equals("�߳�6")) {
					JLFDbPoolClient.get().openConn("main");
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					Thread.currentThread().sleep(1000);
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
				} else if (threadName.equals("�߳�5") || threadName.equals("�߳�7")) {
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
				} else {
					JLFDbPoolClient.get().openConn("main");

					System.out.println(Thread.currentThread().getName() + ":" + JLFDbPoolClient.get().getConn("main").hashCode());
					JLFDbPoolClient.get().closeConn("main");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		plugins.add(new JLFDbPoolClient(new DbPoolWolfServer()));
		plugins.add(new JLFJsonClient(new FastJsonServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}
}