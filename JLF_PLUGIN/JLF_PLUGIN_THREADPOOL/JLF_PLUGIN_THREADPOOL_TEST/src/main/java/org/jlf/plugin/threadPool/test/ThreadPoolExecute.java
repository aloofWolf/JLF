package org.jlf.plugin.threadPool.test;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;

/**
 * 
 * @ClassName: ThreadPoolExecute
 * @Description:�̳߳صľ���ִ��
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class ThreadPoolExecute extends JLFThreadPoolExecute {

	@Override
	public void execute(Object bean) throws Exception {
		Thread.sleep(1000);
		Integer i = (Integer) bean;
		int remainder = i % 2;
		if (remainder > 0) {
			throw new JLFException("ִ��ʧ��");
		}

	}

	@Override
	public int getThreadPoolNum() {
		return 100;
	}
}
