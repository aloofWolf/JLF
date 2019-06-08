package org.jlf.plugin.threadPool.api;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @ClassName: JLFThreadPoolResp
 * @Description:�̳߳ص�ִ�н��
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public class JLFThreadPoolResult<T extends Object> {

	private Integer successCount; // ִ�гɹ�����
	private Integer failCount; // ִ��ʧ�ܱ���
	private Vector<T> successBeans; // ִ�гɹ���bean�б�
	private ConcurrentHashMap<T, String> failBeans; // ִ��ʧ�ܵ�beans�Լ�ʧ��ԭ��

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
