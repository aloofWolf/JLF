package org.jlf.plugin.threadPool.user.api;

public interface JLFThreadPoolSubmit<T> {

	/**
	 * 
	 * @Title: execute
	 * @Description:每个线程的具体执行方法
	 * @param bean
	 * @throws Exception
	 */
	public abstract void execute(T bean) throws Exception;

	/**
	 * 
	 * @Title: ResourceRecovery
	 * @Description:线程结束后的资源回收
	 */
	public default void ResourceRecovery() {
	}

}
