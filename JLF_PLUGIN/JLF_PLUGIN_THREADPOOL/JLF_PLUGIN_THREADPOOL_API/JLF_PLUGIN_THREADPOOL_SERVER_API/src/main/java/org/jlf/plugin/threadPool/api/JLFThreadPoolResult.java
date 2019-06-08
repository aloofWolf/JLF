package org.jlf.plugin.threadPool.api;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @ClassName: JLFThreadPoolResp
 * @Description:线程池的执行结果
 * @author Lone Wolf
 * @date 2019年5月28日
 */
public class JLFThreadPoolResult<T extends Object> {

	private Integer successCount; // 执行成功笔数
	private Integer failCount; // 执行失败笔数
	private Vector<T> successBeans; // 执行成功的bean列表
	private ConcurrentHashMap<T, String> failBeans; // 执行失败的beans以及失败原因

	public JLFThreadPoolResult(Vector<T> successBeans, ConcurrentHashMap<T, String> failBeans) {
		this.successCount = successBeans.size();
		this.failCount = failBeans.size();
		this.successBeans = successBeans;
		this.failBeans = failBeans;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public Vector<T> getSuccessBeans() {
		return successBeans;
	}

	public void setSuccessBeans(Vector<T> successBeans) {
		this.successBeans = successBeans;
	}

	public ConcurrentHashMap<T, String> getFailBeans() {
		return failBeans;
	}

	public void setFailBeans(ConcurrentHashMap<T, String> failBeans) {
		this.failBeans = failBeans;
	}

}
