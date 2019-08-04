package org.jlf.plugin.dbPool.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbWolfTest
 * @Description:DbWolf����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class DbPoolTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:���Զ��߳���,ȡ��conn�Ƿ��̰߳�ȫ������ͨ��
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		DbPoolTest server = new DbPoolTest();
		JLFCore.starts();
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
					JLFDbPoolClient.get().openConn(JLFDbPool.mainDbName);
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					Thread.currentThread().sleep(1000);
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
				} else if (threadName.equals("�߳�5") || threadName.equals("�߳�7")) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
				} else {
					JLFDbPoolClient.get().openConn(JLFDbPool.mainDbName);

					System.out.println(Thread.currentThread().getName() + ":"
							+ JLFDbPoolClient.get().getConn(JLFDbPool.mainDbName).hashCode());
					JLFDbPoolClient.get().closeConn(JLFDbPool.mainDbName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}