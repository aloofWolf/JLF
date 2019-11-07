package org.jlf.plugin.server.core.threadPool.custom;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: ThreadPoolCustomConfig
 * @Description: ThreadPoolCustomConfig
 * @author Lone Wolf
 * @date 2019Äê11ÔÂ7ÈÕ
 */
public class ThreadPoolCustomConfig {

	@JLFCheckAnn(isNull = true)
	private Integer corePoolSize = 10;
	@JLFCheckAnn(isNull = true)
	private Integer capacity = Integer.MAX_VALUE;
	@JLFCheckAnn(isNull = true)
	private Integer maximumPoolSize = 30;
	@JLFCheckAnn(isNull = true)
	private Long keepAliveTime = 3l;

	public Integer getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(Integer corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(Integer maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public Long getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(Long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

}
