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
 * @date 2019年5月28日
 */
public class ThreadPoolCustomCore implements JLFThreadPool {
	
	private static ExecutorService executeService;
	
	static{
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(20);
		executeService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,queue);
	}

	@Override
	public <T extends Object> JLFThreadPoolResult<T> execute(List<T> beans, JLFThreadPoolExecute execute) {
		Long statrTime = System.currentTimeMillis();
		LogUtil.get().debug("%s:线程池任务开始", execute.getThreadPoolName());
		Vector<T> successBeans = new Vector<T>();
		ConcurrentHashMap<T, String> failBeans = new ConcurrentHashMap<T, String>();
		if (beans == null) {
			return new JLFThreadPoolResult<T>(successBeans, failBeans);
		}
		int size = beans.size();
		LogUtil.get().debug(size + "");
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(size);
		ExecutorService executeService = new ThreadPoolExecutor(execute.getThreadPoolNum(), execute.getThreadPoolNum(),
                0L, TimeUnit.MILLISECONDS,queue);
		List<FutureExt<T>> futures = new ArrayList<FutureExt<T>>();
		for (T bean : beans) {
			Future<String> future = executeService.submit(new ExecuteThread<T>(bean, execute));
			futures.add(new FutureExt<T>(future, bean));

		}
		executeService.shutdown(); // 关闭线程池,不在接收新的任务
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
		LogUtil.get().debug("%s:线程池任务结束", execute.getThreadPoolName());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().debug("所花费时间" + (endTime - statrTime));
		return new JLFThreadPoolResult<T>(successBeans, failBeans);
	}
	
	@Override
	public <T> void submit(T bean, JLFThreadPoolSubmit submit) {
		executeService.submit(new ExecuteThread<T>(bean, submit));
		
	}

	/**
	 * 
	 * @ClassName: ExecuteThread
	 * @Description:Callable线程
	 * @author Lone Wolf
	 * @date 2019年5月28日
	 */
	class ExecuteThread<T extends Object> implements Callable<String> {

		private T bean;
		private JLFThreadPoolSubmit submit;

		public ExecuteThread(T bean, JLFThreadPoolSubmit submit) {
			this.bean = bean;
			this.submit = submit;
		}

		@Override
		public String call() {
			try {
				submit.execute(bean);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				String errMsg = e.getMessage();
				if (errMsg == null || errMsg.length() == 0) {
					errMsg = "系统错误";
				}
				return errMsg;
			} finally {
				submit.ResourceRecovery();
			}
		}

	}

	
}
