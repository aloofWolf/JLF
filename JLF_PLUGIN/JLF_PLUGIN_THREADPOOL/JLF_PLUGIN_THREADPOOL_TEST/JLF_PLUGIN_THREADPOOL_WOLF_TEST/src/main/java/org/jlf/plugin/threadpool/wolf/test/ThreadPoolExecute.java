package org.jlf.plugin.threadpool.wolf.test;

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
		Integer i = (Integer) bean;
		int remainder = i % 2;
		if (remainder > 0) {
			throw new Exception("ִ��ʧ��");
		}

	}

}
