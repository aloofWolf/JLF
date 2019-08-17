package org.jlf.plugin.server.core.threadPool.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.threadPool.api.JLFThreadPool;
import org.jlf.plugin.threadPool.api.JLFThreadPoolResult;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;

/**
 * 
 * @ClassName: ThreadPoolCustomCore
 * @Description:ThreadPoolCustomCore
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public class ThreadPoolCustomCore implements JLFThreadPool {
	
	private static ExecutorService executeService;
	
	static{
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1);
		executeService = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,queue);
	}

	@Override
	public <T extends Object> JLFThreadPoolResult<T> execute(List<T> beans, JLFThreadPoolExecute<T> execute) {
		Long statrTime = System.currentTimeMillis();
		LogUtil.get().info("%s:�̳߳�����ʼ", execute.getThreadPoolName());
		Vector<T> successBeans = new Vector<T>();
		ConcurrentHashMap<T, String> failBeans = new ConcurrentHashMap<T, String>();
		if (beans == null) {
			return new JLFThreadPoolResult<T>(successBeans, failBeans);
		}
		int size = beans.size();
		LogUtil.get().debug(size + "");
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1);
		ExecutorService executeService = new ThreadPoolExecutor(execute.getThreadPoolNum(), execute.getThreadPoolNum(),
                0L, TimeUnit.MILLISECONDS,queue);
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
		/*for (FutureExt<T> future : futures) {
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
		}*/
		LogUtil.get().info("%s:�̳߳��������", execute.getThreadPoolName());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().info("������ʱ��" + (endTime - statrTime));
		return new JLFThreadPoolResult<T>(successBeans, failBeans);
	}
	
	@Override
	public <T> void submit(T bean, JLFThreadPoolSubmit<T> submit) {
		executeService.submit(new ExecuteThread<T>(bean, submit));
		
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
		private JLFThreadPoolSubmit<T> submit;

		public ExecuteThread(T bean, JLFThreadPoolSubmit<T> submit) {
			this.bean = bean;
			this.submit = submit;
		}

		@Override
		public String call() {
			try {
				submit.execute(bean);
				return "success";
			} catch (Throwable e) {
				e.printStackTrace();
				String errMsg = e.getMessage();
				if (errMsg == null || errMsg.length() == 0) {
					errMsg = "ϵͳ����";
				}
				return errMsg;
			} finally {
				submit.ResourceRecovery();
			}
		}

	}

	
}
