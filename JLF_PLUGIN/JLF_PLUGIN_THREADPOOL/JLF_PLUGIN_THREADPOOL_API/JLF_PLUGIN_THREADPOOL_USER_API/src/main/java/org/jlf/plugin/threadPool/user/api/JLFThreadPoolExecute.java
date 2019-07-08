package org.jlf.plugin.threadPool.user.api;

/**
 * 
 * @ClassName: JLFThreadPoolExecute
 * @Description:线程池的具体执行，不需要具体服务实现,需具体调用者实现
 * @author Lone Wolf
 * @date 2019年5月28日
 */
public abstract class JLFThreadPoolExecute {

	/**
	 * 
	 * @Title: getThreadPoolName
	 * @Description:线程池名称,默认当前类的名称
	 * @return
	 */
	public String getThreadPoolName() {
		return this.getClass().getName();
	}

	/**
	 * 
	 * @Title: getThreadPoolNum
	 * @Description:最大线程数量,默认5个
	 * @return
	 */
	public int getThreadPoolNum() {
		return 5;
	}

	/**
	 * 
	 * @Title: execute
	 * @Description:每个线程的具体执行方法
	 * @param bean
	 * @throws Exception 
	 */
	public abstract void execute(Object bean) throws Exception;
}
