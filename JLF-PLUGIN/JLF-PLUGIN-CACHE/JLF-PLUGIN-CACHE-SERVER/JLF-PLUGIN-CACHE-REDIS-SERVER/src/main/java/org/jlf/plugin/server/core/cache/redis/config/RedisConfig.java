package org.jlf.plugin.server.core.cache.redis.config;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: RedisConfig
 * @Description:reids配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisConfig {

	@JLFCheckAnn
	private String ip;
	@JLFCheckAnn
	private Integer port;
	
	private Integer maxTotal;
	private Integer maxIdle;
	private Long maxWaitMillis;
	private BooleanType TestOnBorrow;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public BooleanType getTestOnBorrow() {
		return TestOnBorrow;
	}

	public void setTestOnBorrow(BooleanType testOnBorrow) {
		TestOnBorrow = testOnBorrow;
	}
	
	

}
