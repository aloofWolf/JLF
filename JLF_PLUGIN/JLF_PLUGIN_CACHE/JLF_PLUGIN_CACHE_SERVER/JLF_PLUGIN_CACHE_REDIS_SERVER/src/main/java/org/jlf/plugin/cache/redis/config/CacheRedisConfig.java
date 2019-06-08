package org.jlf.plugin.cache.redis.config;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: CacheRedisConfig
 * @Description:reids������Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
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
