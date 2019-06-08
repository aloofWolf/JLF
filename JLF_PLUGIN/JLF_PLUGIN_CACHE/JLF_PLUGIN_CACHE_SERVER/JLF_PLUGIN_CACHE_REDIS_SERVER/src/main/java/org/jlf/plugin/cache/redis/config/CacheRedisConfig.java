package org.jlf.plugin.cache.redis.config;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: CacheRedisConfig
 * @Description:reids配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class CacheRedisConfig {

	@JLFCheckAnn
	private String ip;
	@JLFCheckAnn
	private Integer port;

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

}
