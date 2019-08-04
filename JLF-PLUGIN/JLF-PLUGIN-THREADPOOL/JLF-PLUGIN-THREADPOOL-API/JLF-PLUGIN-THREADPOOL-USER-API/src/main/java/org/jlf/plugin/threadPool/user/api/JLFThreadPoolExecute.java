package org.jlf.plugin.threadPool.user.api;

/**
 * 
 * @ClassName: JLFThreadPoolExecute
 * @Description:�̳߳صľ���ִ�У�����Ҫ�������ʵ��,����������ʵ��
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public interface JLFThreadPoolExecute extends JLFThreadPoolSubmit{

	/**
	 * 
	 * @Title: getThreadPoolName
	 * @Description:�̳߳�����,Ĭ�ϵ�ǰ�������
	 * @return
	 */
	public  default String getThreadPoolName() {
		return this.getClass().getName();
	}

	/**
	 * 
	 * @Title: getThreadPoolNum
	 * @Description:����߳�����,Ĭ��5��
	 * @return
	 */
	public default int getThreadPoolNum() {
		return 5;
	}
}
