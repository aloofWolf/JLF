package org.jlf.product.server.core.quartz.custom.config;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: QuartzConfig
 * @Description:quartz配置
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class QuartzConfig {

	@JLFCheckAnn(isNull = true, desc = "最大线程数")
	private Integer maxThreads;
	@JLFCheckAnn(isNull = true, desc = "主任务扫描间隔时间")
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
