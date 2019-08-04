package org.jlf.plugin.server.core.cache.redisCluster.config;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import redis.clients.jedis.HostAndPort;

/**
 * 
 * @ClassName: RedisClusterConfig
 * @Description:reidsCluster配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisClusterConfig {

	@JLFCheckAnn(isSkipValidate=true)
	private Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
	
	private Integer maxTotal;
	private Integer maxIdle;
	private Long maxWaitMillis;
	private BooleanType TestOnBorrow;

	public Set<HostAndPort> getHostAndPorts() {
		return hostAndPorts;
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

	public void setHostAndPorts(Set<HostAndPort> hostAndPorts) {
		this.hostAndPorts = hostAndPorts;
	}
	
	public void setHostAndPosts(Properties hosts){
		if (hosts != null) {
			HostAndPort hostAndPort = null;
			for (Enumeration<Object> keys = hosts.keys(); keys.hasMoreElements();) {
				String ip = (String) keys.nextElement();
				int port = Integer.valueOf(hosts.getProperty(ip));
				hostAndPort = new HostAndPort(ip, port);
				hostAndPorts.add(hostAndPort);
			}
		} else {
			throw new JLFException("redis-cluster未配置hosts");
		}
	}
	
	

}
