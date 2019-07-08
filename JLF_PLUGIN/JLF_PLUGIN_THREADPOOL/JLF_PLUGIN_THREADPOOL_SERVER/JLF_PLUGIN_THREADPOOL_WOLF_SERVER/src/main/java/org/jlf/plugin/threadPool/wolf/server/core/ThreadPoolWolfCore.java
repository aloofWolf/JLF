package org.jlf.plugin.threadPool.wolf.server.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.dbPool.client.JLFDbPoolClient;
import org.jlf.plugin.threadPool.api.JLFThreadPool;
import org.jlf.plugin.threadPool.api.JLFThreadPoolResult;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;

/**
 * 
 * @ClassName: ThreadPoolWolfCore
 * @Description:ThreadPoolWolfCore
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public class ThreadPoolWolfCore implements JLFThreadPool {

	@Override
	public <T extends Object> JLFThreadPoolResult<T> execute(List<T> beans, JLFThreadPoolExecute execute) {
		Long statrTime = System.currentTimeMillis();
		LogUtil.get().debug("%s:�̳߳�����ʼ", execute.getThreadPoolName());
		Vector<T> successBeans = new Vector<T>();
		ConcurrentHashMap<T, String> failBeans = new ConcurrentHashMap<T, String>();
		if (beans == null) {
			return new JLFThreadPoolResult<T>(successBeans, failBeans);
		}
		LogUtil.get().debug(beans.size() + "");
		ExecutorService executeService = Executors.newFixedThreadPool(execute.getThreadPoolNum());
		List<FutureExt<T>> futures = new ArrayList<FutureExt<T>>();
		for (T bean : beans) {
			Future<String> future = executeService.submit(new ExecuteThread<T>(bean, execute));
			futures.add(new FutureExt<T>(future, bean));

		}
		executeService.shutdown(); // �ر��̳߳�,���ڽ����µ�����
		while (true) {
			if (executeService.isTerminated()) {
				break;
			}
		}
		for (FutureExt<T> future : futures) {
			String result = null;
			try {
				result = future.getFuture().get();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			if ("success".equals(result)) {
				successBeans.addElement(future.getBean());
			} else {
				failBeans.put(future.getBean(), result);
			}
		}
		LogUtil.get().debug("%s:�̳߳��������", execute.getThreadPoolName());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().debug("������ʱ��" + (endTime - statrTime));
		return new JLFThreadPoolResult<T>(successBeans, failBeans);
	}

	/**
	 * 
	 * @ClassName: ExecuteThread
	 * @Description:Callable�߳�
	 * @author Lone Wolf
	 * @date 2019��5��28��
	 */
	class ExecuteThread<T extends Object> implements Callable<String> {

		private T bean;
		private JLFThreadPoolExecute execute;

		public ExecuteThread(T bean, JLFThreadPoolExecute execute) {
			this.bean = bean;
			this.execute = execute;
		}

		@Override
		public String call() {
			try {
				execute.execute(bean);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				String errMsg = e.getMessage();
				if (errMsg == null || errMsg.length() == 0) {
					errMsg = "ϵͳ����";
				}
				return errMsg;
			} finally {
				JLFDbPoolClient.get().closeAllConn(); // �رյ�ǰ�߳��������ݿ�����
			}
		}

	}
}
