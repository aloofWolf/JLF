package org.jlf.plugin.threadPool.user.api;

public interface JLFThreadPoolSubmit {

	/**
	 * 
	 * @param <T>
	 * @Title: execute
	 * @Description:ÿ���̵߳ľ���ִ�з���
	 * @param bean
	 * @throws Exception
	 */
	public abstract <T extends Object> void execute(T bean) throws Exception;

	/**
	 * 
	 * @Title: ResourceRecovery
	 * @Description:�߳̽��������Դ����
	 */
	public default void ResourceRecovery() {
	}

}
