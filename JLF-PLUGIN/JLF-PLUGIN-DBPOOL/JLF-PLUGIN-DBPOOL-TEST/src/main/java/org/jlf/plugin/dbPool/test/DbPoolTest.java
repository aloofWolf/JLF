package org.jlf.plugin.dbPool.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbWolfTest
 * @Description:DbWolf测试
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class DbPoolTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:测试多线程下,取到conn是否线程安全，测试通过
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

		t1.setName("线程1");
		t2.setName("线程2");
		t3.setName("线程3");
		t4.setName("线程4");
		t5.setName("线程5");
		t6.setName("线程6");
		t7.setName("线程7");
		t8.setName("线程8");
		t9.setName("线程9");
		t10.setName("线程10");

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
				if (threadName.equals("线程4") || threadName.equals("线程6")) {
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
				} else if (threadName.equals("线程5") || threadName.equals("线程7")) {
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