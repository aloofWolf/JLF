package org.jlf.plugin.threadPool.user.api;

public interface JLFThreadPoolSubmit<T> {

	/**
	 * 
	 * @Title: execute
	 * @Description:ÿ���̵߳ľ���ִ�з���
	 * @param bean
	 * @throws Exception
	 */
	public abstract void execute(T bean) throws Exception;

	/**
	 * 
	 * @Title: ResourceRecovery
	 * @Description:�߳̽��������Դ����
	 */
	public default void ResourceRecovery() {
	}

}
