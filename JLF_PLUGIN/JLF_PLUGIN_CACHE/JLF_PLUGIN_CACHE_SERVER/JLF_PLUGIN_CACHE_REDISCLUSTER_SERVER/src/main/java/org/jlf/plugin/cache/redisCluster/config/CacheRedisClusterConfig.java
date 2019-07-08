package org.jlf.plugin.cache.redisCluster.config;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.IniUtil;

import redis.clients.jedis.HostAndPort;

/**
 * 
 * @ClassName: CacheRedisClusterConfig
 * @Description:reidsCluster配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class CacheRedisClusterConfig {
	
	private Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
	
	public CacheRedisClusterConfig(IniUtil ini) throws JLFException{
         Properties hosts = ini.getSection("hosts");
		
		if (hosts != null) {
			HostAndPort hostAndPort = null;
			for (Enumeration<Object> keys = hosts.keys(); keys.hasMoreElements();) {
				String ip = (String) keys.nextElement();
				int port = Integer.valueOf(hosts.getProperty(ip));
				hostAndPort = new HostAndPort(ip,port);
				hostAndPorts.add(hostAndPort);
			}
		} else {
			throw new JLFException("redis-cluster未配置hosts");
		}
	}

	public Set<HostAndPort> getHostAndPorts() {
		return hostAndPorts;
	}

	
}
