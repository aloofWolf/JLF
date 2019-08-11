package org.jlf.common.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: ConcurrentUtil
 * @Description:并发工具类
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class ConcurrentUtil {

	/**
	 * 
	 * @Title: concurrent
	 * @Description:执行并发操作
	 * @param concurrentNum
	 * @param operator
	 * @return
	 */
	public static ConcurrentResult concurrent(int concurrentNum, ConcurrentOperator operator) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		CountDownLatch countDownLatch = new CountDownLatch(concurrentNum); // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
		CountDownLatch countDownLatch2 = new CountDownLatch(concurrentNum); // 保证所有线程执行完了再打印atomicInteger的值
		ExecutorService executorService = Executors.newFixedThreadPool(concurrentNum);
		for (int i = 0; i < concurrentNum; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						countDownLatch.await(); // 一直阻塞当前线程，直到计时器的值为0,保证同时并发
						operator.execute();
						atomicInteger.incrementAndGet();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						countDownLatch2.countDown();
					}
				}
			});
			countDownLatch.countDown();
		}

		Long statrTime = System.currentTimeMillis();
		try {
			countDownLatch2.await();// 保证所有线程执行完
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		Long time = endTime - statrTime;
		Integer successNum = atomicInteger.get();
		LogUtil.get().info("所花费时间:{}", time);
		LogUtil.get().info("成功数:{}", successNum);
		executorService.shutdown();
		return new ConcurrentResult(time, successNum);
	}

}
