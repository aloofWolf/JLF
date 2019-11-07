package org.jlf.plugin.server.core.threadPool.custom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: ThreadPoolCustomManager
 * @Description: ThreadPoolCustomManager
 * @author Lone Wolf
 * @date 2019年11月7日
 */
public class ThreadPoolCustomManager {

	private static ExecutorService executeService;

	/**
	 * 
	 * @Title: init
	 * @Description: 初始化executeService
	 * @param config
	 */
	public static void init(ThreadPoolCustomConfig config) {
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(config.getCapacity());
		executeService = new ThreadPoolExecutor(config.getCorePoolSize(), config.getMaximumPoolSize(),
				config.getKeepAliveTime(), TimeUnit.MILLISECONDS, queue);
	}

	protected static ExecutorService getExecuteService() {
		return executeService;
	}

}
