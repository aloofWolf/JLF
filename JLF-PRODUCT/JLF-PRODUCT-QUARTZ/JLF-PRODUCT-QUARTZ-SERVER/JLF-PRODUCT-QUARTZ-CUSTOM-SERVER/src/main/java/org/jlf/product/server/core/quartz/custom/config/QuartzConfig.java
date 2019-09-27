package org.jlf.product.server.core.quartz.custom.config;

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

	public Integer getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads(Integer maxThreads) {
		if (maxThreads == null) {
			this.maxThreads = 6;
		}else{
			this.maxThreads = maxThreads;
		}
		
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		if (seconds == null) {
			this.seconds = 30;
		}else{
			this.seconds = seconds;
		}
		
	}	
}
