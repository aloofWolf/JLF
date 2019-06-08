package org.jlf.plugin.push.user.api.config;

import java.security.SecureRandom;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

/**
 * 
 * @ClassName: JLFHttpConfig
 * @Description:http配置信息
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public abstract class JLFHttpConfig extends JLFTransferConfig {

	/**
	 * 
	 * @Title: getHostName
	 * @Description:获取服务器域名
	 * @return
	 */
	public abstract String getHostName();

	/**
	 * 
	 * @Title: getUrl
	 * @Description:获取url
	 * @return
	 */
	public abstract String getUrl();

	/**
	 * 
	 * @Title: getMaxConnCount
	 * @Description:获取连接池的最大连接数,可被子类覆盖
	 * @return
	 */
	public Integer getMaxConnCount() {
		return 50;
	}

	/**
	 * 
	 * @Title: getHttpEntity
	 * @Description:获取HttpEntity,可被子类覆盖
	 * @param plainText
	 * @return
	 */
	public HttpEntity getHttpEntity(String plainText) {
		HttpEntity entity = new StringEntity(plainText, getCharset());
		return entity;
	}

	/**
	 * 
	 * @Title: getSpecialHeaderSetingInfo
	 * @Description:获取额外的http header设置信息，可被子类覆盖
	 * @return
	 */
	public Map<String, String> getSpecialHeaderSetingInfo() {
		return null;
	}

	/**
	 * 
	 * @Title: getSSLContext
	 * @Description:获取SSLContext,默认采用绕过验证的SSLContext,可被子类覆盖
	 * @return
	 * @throws Exception
	 */
	public SSLContext getSSLContext() throws Exception {
		SSLContext sslcontext = SSLContext.getInstance("TLSv1");
		TrustManager[] trustManagersWithoutVerify = new TrustManager[] { new JLFX509TrustManagerWithoutVerify() };
		sslcontext.init((javax.net.ssl.KeyManager[]) null, trustManagersWithoutVerify, (SecureRandom) null);
		return sslcontext;
	}

}
