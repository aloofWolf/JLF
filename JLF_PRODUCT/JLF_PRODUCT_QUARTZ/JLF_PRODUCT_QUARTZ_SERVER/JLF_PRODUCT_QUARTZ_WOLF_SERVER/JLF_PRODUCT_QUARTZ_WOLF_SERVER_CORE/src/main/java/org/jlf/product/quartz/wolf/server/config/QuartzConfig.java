package org.jlf.product.quartz.wolf.server.config;

/**
 * 
 * @ClassName: QuartzConfig
 * @Description:quartz配置
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class QuartzConfig {

	private Integer maxThreads; // 最大线程数
	private Integer seconds; // 主任务扫描间隔时间
	private String dbNames; // 加载的数据库集合，以逗号分隔

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
