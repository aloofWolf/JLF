package org.jlf.plugin.server.core.push.custom.send.http;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.impl.client.CloseableHttpClient;
import org.jlf.plugin.push.user.api.config.JLFPushHttpConfig;

/**
 * 
 * @ClassName: HttpPools
 * @Description:http连接池集合,每个域名对应一个连接池
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class HttpPools {

	/**
	 * 连接池集合的map
	 */
	private static ConcurrentHashMap<String, HttpPool> pools = new ConcurrentHashMap<String, HttpPool>();

	/**
	 * 
	 * @Title: getClient
	 * @Description:获取client对象
	 * @param config
	 * @return
	 */
	public static CloseableHttpClient getClient(JLFPushHttpConfig config) {
		HttpPool pool = pools.get(config.getHostName());
		if (pool == null) {
			pool = new HttpPool(config);
			pools.put(config.getHostName(), pool);
		}
		return pool.getClient();

	}

}
