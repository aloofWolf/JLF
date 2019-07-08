package org.jlf.plugin.threadPool.user.api;

/**
 * 
 * @ClassName: JLFThreadPoolExecute
 * @Description:�̳߳صľ���ִ�У�����Ҫ�������ʵ��,����������ʵ��
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public abstract class JLFThreadPoolExecute {

	/**
	 * 
	 * @Title: getThreadPoolName
	 * @Description:�̳߳�����,Ĭ�ϵ�ǰ�������
	 * @return
	 */
	public String getThreadPoolName() {
		return this.getClass().getName();
	}

	/**
	 * 
	 * @Title: getThreadPoolNum
	 * @Description:����߳�����,Ĭ��5��
	 * @return
	 */
	public int getThreadPoolNum() {
		return 5;
	}

	/**
	 * 
	 * @Title: execute
	 * @Description:ÿ���̵߳ľ���ִ�з���
	 * @param bean
	 * @throws Exception 
	 */
	public abstract void execute(Object bean) throws Exception;
}
