package org.jlf.plugin.push.wolf.server.core.send.http;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.impl.client.CloseableHttpClient;
import org.jlf.plugin.push.user.api.config.JLFHttpConfig;

/**
 * 
 * @ClassName: HttpPools
 * @Description:http���ӳؼ���,ÿ��������Ӧһ�����ӳ�
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class HttpPools {

	/**
	 * ���ӳؼ��ϵ�map
	 */
	private static ConcurrentHashMap<String, HttpPool> pools = new ConcurrentHashMap<String, HttpPool>();

	/**
	 * 
	 * @Title: getClient
	 * @Description:��ȡclient����
	 * @param config
	 * @return
	 */
	public static CloseableHttpClient getClient(JLFHttpConfig config) {
		HttpPool pool = pools.get(config.getHostName());
		if (pool == null) {
			pool = new HttpPool(config);
			pools.put(config.getHostName(), pool);
		}
		return pool.getClient();

	}

}
