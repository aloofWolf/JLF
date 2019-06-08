package org.jlf.plugin.push.wolf.server.core.send.http;

import java.net.ConnectException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.jlf.common.util.LogUtil;
import org.jlf.plugin.push.user.api.config.JLFHttpConfig;

/**
 * 
 * @ClassName: HttpSend
 * @Description:http发送
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class HttpSend {

	/**
	 * 
	    * @Title: send
	    * @Description:发送数据
	    * @param config
	    * @param datagram
	    * @return
	    * @throws Exception
	 */
	public static String send(JLFHttpConfig config, String datagram) throws Exception {
		CloseableHttpClient client = HttpPools.getClient(config);
		HttpEntity entity = config.getHttpEntity(datagram);
		HttpPost httpPost = new HttpPost(config.getUrl());

		HttpResponse response = null;
		if (config.getSpecialHeaderSetingInfo() != null && config.getSpecialHeaderSetingInfo().size() > 0) {
			LogUtil.get().debug("设置http header info");
			Map<String, String> headers = config.getSpecialHeaderSetingInfo();
			for (String key : headers.keySet()) {
				LogUtil.get().debug("setting " + key);
				httpPost.addHeader(key, headers.get(key));
			}
		}
		httpPost.setEntity(entity);
		String respMsg = null;
		try {
			LogUtil.get().debug("url is:" + config.getUrl());
			LogUtil.get().debug("entity is:" + EntityUtils.toString(entity));
			response = client.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				LogUtil.get().error("statusCode is:" + statusCode);
				LogUtil.get().error(EntityUtils.toString(respEntity));
				throw new ConnectException("请求出错,状态码为:" + statusCode);
			} else {
				HttpEntity respEntity = response.getEntity();
				if (respEntity != null) {
					respMsg = EntityUtils.toString(respEntity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HttpClientUtils.closeQuietly(response);
		}
		LogUtil.get().debug("respMsg is:" + respMsg);
		return respMsg;
	}

}
