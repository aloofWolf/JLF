package org.jlf.plugin.push.wolf.server.core.send.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jlf.plugin.push.user.api.config.JLFHttpConfig;

/**
 * 
 * @ClassName: HttpPool
 * @Description:http连接池
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class HttpPool {

	private HttpClientBuilder build;

	/**
	 * 
	 * 创建一个新的实例 HttpPool.
	 *
	 * @param config
	 */
	public HttpPool(JLFHttpConfig config) {
		this.build = HttpClientBuilder.create();
		initClientConnectionManager(config);
	}

	/**
	 * 
	 * @Title: initClientConnectionManager
	 * @Description:初始化ClientConnectionManager
	 * @param config
	 */
	private void initClientConnectionManager(JLFHttpConfig config) {

		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(config.getConntimeout())
				.setSocketTimeout(config.getReadconntimeout()).build();
		SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).setSoReuseAddress(true)
				.setTcpNoDelay(true).build();

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
				initConnectionSocketFactory(config));
		cm.setDefaultMaxPerRoute(config.getMaxConnCount());
		cm.setMaxTotal(config.getMaxConnCount());
		cm.setDefaultSocketConfig(socketConfig);
		this.build.setDefaultRequestConfig(requestConfig).setConnectionManager(cm);

	}

	/**
	 * 
	 * @Title: initConnectionSocketFactory
	 * @Description:初始化ConnectionSocketFactory
	 * @param config
	 * @return
	 */
	private Registry<ConnectionSocketFactory> initConnectionSocketFactory(JLFHttpConfig config) {
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(config.getSSLContext(), new HostnameVerifier() {
					@Override
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				})).build();
		return socketFactoryRegistry;
	}

	/**
	 * 
	 * @Title: getClient
	 * @Description:获取client
	 * @return
	 */
	public CloseableHttpClient getClient() {
		return this.build.build();
	}

}
