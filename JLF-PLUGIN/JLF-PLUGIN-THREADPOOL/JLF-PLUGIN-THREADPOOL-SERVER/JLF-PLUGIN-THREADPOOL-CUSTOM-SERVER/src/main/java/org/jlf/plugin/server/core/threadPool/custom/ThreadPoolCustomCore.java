package org.jlf.plugin.server.core.threadPool.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.jlf.common.util.LogUtil;
import org.jlf.core.exception.JLFException;
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

	@Override
	public <T extends Object> JLFThreadPoolResult<T> execute(List<T> beans, JLFThreadPoolExecute<T> execute) {
		Long statrTime = System.currentTimeMillis();
		LogUtil.get().info("%s:线程池任务开始", execute.getThreadPoolName());
		Vector<T> successBeans = new Vector<T>();
		ConcurrentHashMap<T, String> failBeans = new ConcurrentHashMap<T, String>();
		if (beans == null) {
			return new JLFThreadPoolResult<T>(successBeans, failBeans);
		}
		int size = beans.size();
		LogUtil.get().debug("待执行的线程数量为:"+size);
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(size);
		ExecutorService executeService = new ThreadPoolExecutor(execute.getThreadPoolNum(), execute.getThreadPoolNum(),
                0L, TimeUnit.MILLISECONDS,queue);
		List<FutureExt<T>> futures = new ArrayList<FutureExt<T>>();
		ExecuteThread<T> t = null;
		CountDownLatch countDownLatch = new CountDownLatch(size);
		for (T bean : beans) {
			boolean newExecuteThreadFlg = true;
			while(newExecuteThreadFlg){  // 如果创建ExecuteThread对象时出现内存溢出,则将当前线程睡眠十分钟后继续创建
				try{
					t = new ExecuteThread<T>(bean, execute,countDownLatch);
					newExecuteThreadFlg = false;
				}catch(OutOfMemoryError e){
					newExecuteThreadFlg = true;
					try {
						Thread.sleep(600000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			
			Future<String> future = executeService.submit(t);
			futures.add(new FutureExt<T>(future, bean));

		}
		executeService.shutdown(); // 关闭线程池,不在接收新的任务
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			throw new JLFException(e);
		}
		
		/**
		 * 统计执行成功和失败数量
		 */
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
		LogUtil.get().info("%s:线程池任务结束", execute.getThreadPoolName());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().info("所花费时间" + (endTime - statrTime));
		return new JLFThreadPoolResult<T>(successBeans, failBeans);
	}
	
	@Override
	public <T> void submit(T bean, JLFThreadPoolSubmit<T> submit) {
		ThreadPoolCustomManager.getExecuteService().submit(new ExecuteThread<T>(bean, submit));
		
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
		private JLFThreadPoolSubmit<T> submit;
		private CountDownLatch countDownLatch;
		
		public ExecuteThread(T bean, JLFThreadPoolSubmit<T> submit) {
			this.bean = bean;
			this.submit = submit;
		}

		public ExecuteThread(T bean, JLFThreadPoolSubmit<T> submit,CountDownLatch countDownLatch) {
			this.bean = bean;
			this.submit = submit;
			this.countDownLatch = countDownLatch;
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
					errMsg = "系统错误";
				}
				return errMsg;
			} finally {
				if(this.countDownLatch != null){
					this.countDownLatch.countDown();
				}
				submit.ResourceRecovery();
			}
		}

	}

	
}
