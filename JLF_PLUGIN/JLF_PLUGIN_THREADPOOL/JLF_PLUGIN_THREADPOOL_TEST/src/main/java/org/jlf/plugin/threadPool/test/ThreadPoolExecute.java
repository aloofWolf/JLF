package org.jlf.plugin.threadPool.test;

import org.jlf.common.exception.JLFException;
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
		Thread.sleep(1000);
		Integer i = (Integer) bean;
		int remainder = i % 2;
		if (remainder > 0) {
			throw new JLFException("执行失败");
		}

	}

	@Override
	public int getThreadPoolNum() {
		return 100;
	}
}
