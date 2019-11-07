package org.jlf.plugin.server.core.cache.redisCluster.config;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName: RedisClusterConfig
 * @Description:reidsCluster配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class RedisClusterConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	
	@JLFCheckAnn(isSkipValidate=true)
	private Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
	
	@JLFCheckAnn(isNull = true)
	private Integer maxTotal;
	@JLFCheckAnn(isNull = true)
	private Integer maxIdle;
	@JLFCheckAnn(isNull = true)
	private Integer minIdle;
	@JLFCheckAnn(isNull = true)
	private Long maxWaitMillis;
	@JLFCheckAnn(isNull = true)
	private BooleanType testOnBorrow;
	@JLFCheckAnn(isNull = true)
	private BooleanType lifo;
	@JLFCheckAnn(isNull = true)
	private BooleanType fairness;
	@JLFCheckAnn(isNull = true)
	private Long minEvictableIdleTimeMillis;
	@JLFCheckAnn(isNull = true)
	private Long softMinEvictableIdleTimeMillis;
	@JLFCheckAnn(isNull = true)
	private Integer numTestsPerEvictionRun;
	@JLFCheckAnn(isNull = true)
	private BooleanType testOnCreate;
	@JLFCheckAnn(isNull = true)
	private BooleanType testOnReturn;
	@JLFCheckAnn(isNull = true)
	private BooleanType testWhileIdle;
	@JLFCheckAnn(isNull = true)
	private Long timeBetweenEvictionRunsMillis;
	@JLFCheckAnn(isNull = true)
	private String evictionPolicyClassName;
	@JLFCheckAnn(isNull = true)
	private BooleanType blockWhenExhausted;
	@JLFCheckAnn(isNull = true)
	private BooleanType jmxEnabled;
	@JLFCheckAnn(isNull = true)
	private String jmxNameBase;
	@JLFCheckAnn(isNull = true)
	private String jmxNamePrefix;
	
	public JedisPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}

	public Set<HostAndPort> getHostAndPorts() {
		return hostAndPorts;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.jedisPoolConfig.setMaxTotal(maxTotal);
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
		this.jedisPoolConfig.setMaxIdle(maxIdle);
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
		this.jedisPoolConfig.setMinIdle(minIdle);
	}

	public Long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
		this.jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
	}

	public BooleanType getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(BooleanType testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
		this.jedisPoolConfig.setTestOnBorrow(testOnBorrow.isBln());
	}

	public BooleanType getLifo() {
		return lifo;
	}

	public void setLifo(BooleanType lifo) {
		this.lifo = lifo;
		this.jedisPoolConfig.setLifo(lifo.isBln());
	}

	public BooleanType getFairness() {
		return fairness;
	}

	public void setFairness(BooleanType fairness) {
		this.fairness = fairness;
		this.jedisPoolConfig.setFairness(fairness.isBln());
	}

	public Long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
		this.jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	}

	public Long getSoftMinEvictableIdleTimeMillis() {
		return softMinEvictableIdleTimeMillis;
	}

	public void setSoftMinEvictableIdleTimeMillis(Long softMinEvictableIdleTimeMillis) {
		this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
		this.jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
	}

	public Integer getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
		this.jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
	}

	public BooleanType getTestOnCreate() {
		return testOnCreate;
	}

	public void setTestOnCreate(BooleanType testOnCreate) {
		this.testOnCreate = testOnCreate;
		this.jedisPoolConfig.setTestOnCreate(testOnCreate.isBln());
	}

	public BooleanType getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(BooleanType testOnReturn) {
		this.testOnReturn = testOnReturn;
		this.jedisPoolConfig.setTestOnReturn(testOnReturn.isBln());
	}

	public BooleanType getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(BooleanType testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
		this.jedisPoolConfig.setTestWhileIdle(testWhileIdle.isBln());
	}

	public Long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
		this.jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	}

	public String getEvictionPolicyClassName() {
		return evictionPolicyClassName;
	}

	public void setEvictionPolicyClassName(String evictionPolicyClassName) {
		this.evictionPolicyClassName = evictionPolicyClassName;
		this.jedisPoolConfig.setEvictionPolicyClassName(evictionPolicyClassName);
	}

	public BooleanType getBlockWhenExhausted() {
		return blockWhenExhausted;
	}

	public void setBlockWhenExhausted(BooleanType blockWhenExhausted) {
		this.blockWhenExhausted = blockWhenExhausted;
		this.jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted.isBln());
	}

	public BooleanType getJmxEnabled() {
		return jmxEnabled;
	}

	public void setJmxEnabled(BooleanType jmxEnabled) {
		this.jmxEnabled = jmxEnabled;
		this.jedisPoolConfig.setJmxEnabled(jmxEnabled.isBln());
	}

	public String getJmxNameBase() {
		return jmxNameBase;
	}

	public void setJmxNameBase(String jmxNameBase) {
		this.jmxNameBase = jmxNameBase;
		this.jedisPoolConfig.setJmxNameBase(jmxNameBase);
	}

	public String getJmxNamePrefix() {
		return jmxNamePrefix;
	}

	public void setJmxNamePrefix(String jmxNamePrefix) {
		this.jmxNamePrefix = jmxNamePrefix;
		this.jedisPoolConfig.setJmxNamePrefix(jmxNamePrefix);
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
