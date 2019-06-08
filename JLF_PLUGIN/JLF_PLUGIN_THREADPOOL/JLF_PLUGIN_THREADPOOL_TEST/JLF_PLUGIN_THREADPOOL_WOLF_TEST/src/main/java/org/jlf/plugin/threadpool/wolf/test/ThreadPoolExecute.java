package org.jlf.plugin.threadpool.wolf.test;

import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;

/**
 * 
 * @ClassName: ThreadPoolExecute
 * @Description:线程池的具体执行
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class ThreadPoolExecute extends JLFThreadPoolExecute {

	@Override
	public void execute(Object bean) throws Exception {
		Integer i = (Integer) bean;
		int remainder = i % 2;
		if (remainder > 0) {
			throw new Exception("执行失败");
		}

	}

}
