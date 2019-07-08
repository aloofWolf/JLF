package org.jlf.product.quartz.wolf.server.config;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: QuartzConfig
 * @Description:quartz����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class QuartzConfig {

	@JLFCheckAnn(isNull = true, desc = "����߳���")
	private Integer maxThreads;
	@JLFCheckAnn(isNull = true, desc = "������ɨ����ʱ��")
	private Integer seconds;
	@JLFCheckAnn(desc = "���ص����ݿ⼯�ϣ��Զ��ŷָ�")
	private String dbNames;

	public Integer getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads(Integer maxThreads) {
		if (maxThreads == null) {
			this.maxThreads = 6;
		}
		this.maxThreads = maxThreads;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		if (seconds == null) {
			this.seconds = 30;
		}
		this.seconds = seconds;
	}

	public String getDbNames() {
		return dbNames;
	}

	public void setDbNames(String dbNames) {
		this.dbNames = dbNames;
	}

}
