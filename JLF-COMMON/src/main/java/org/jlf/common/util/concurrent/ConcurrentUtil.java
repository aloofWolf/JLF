package org.jlf.common.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: ConcurrentUtil
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class ConcurrentUtil {

	/**
	 * 
	 * @Title: concurrent
	 * @Description:ִ�в�������
	 * @param concurrentNum
	 * @param operator
	 * @return
	 */
	public static ConcurrentResult concurrent(int concurrentNum, ConcurrentOperator operator) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		CountDownLatch countDownLatch = new CountDownLatch(concurrentNum); // �൱�ڼ������������ж�׼�����ˣ���һ��ִ�У�ģ�¶ಢ������֤������
		CountDownLatch countDownLatch2 = new CountDownLatch(concurrentNum); // ��֤�����߳�ִ�������ٴ�ӡatomicInteger��ֵ
		ExecutorService executorService = Executors.newFixedThreadPool(concurrentNum);
		for (int i = 0; i < concurrentNum; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						countDownLatch.await(); // һֱ������ǰ�̣߳�ֱ����ʱ����ֵΪ0,��֤ͬʱ����
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
			countDownLatch2.await();// ��֤�����߳�ִ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		Long time = endTime - statrTime;
		Integer successNum = atomicInteger.get();
		LogUtil.get().info("������ʱ��:{}", time);
		LogUtil.get().info("�ɹ���:{}", successNum);
		executorService.shutdown();
		return new ConcurrentResult(time, successNum);
	}

}
