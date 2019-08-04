package org.jlf.plugin.push.user.api.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFPushHttpConfig
 * @Description:http������Ϣ
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public abstract class JLFPushHttpConfig extends JLFPushTransferConfig {

	/**
	 * 
	 * @Title: getHostName
	 * @Description:��ȡ����������
	 * @return
	 */
	public abstract String getHostName();

	/**
	 * 
	 * @Title: getUrl
	 * @Description:��ȡurl
	 * @return
	 */
	public abstract String getUrl();

	/**
	 * 
	 * @Title: getMaxConnCount
	 * @Description:��ȡ���ӳص����������,�ɱ����า��
	 * @return
	 */
	public Integer getMaxConnCount() {
		return 50;
	}

	/**
	 * 
	 * @Title: getHttpEntity
	 * @Description:��ȡHttpEntity,�ɱ����า��
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
	 * @Description:��ȡ�����http header������Ϣ���ɱ����า��
	 * @return
	 */
	public Map<String, String> getSpecialHeaderSetingInfo() {
		return null;
	}

	/**
	 * 
	 * @Title: getSSLContext
	 * @Description:��ȡSSLContext,Ĭ�ϲ����ƹ���֤��SSLContext,�ɱ����า��
	 * @return
	 */
	public SSLContext getSSLContext() {
		SSLContext sslcontext;
		try {
			sslcontext = SSLContext.getInstance("TLSv1");
			TrustManager[] trustManagersWithoutVerify = new TrustManager[] {
					new JLFPushX509TrustManagerWithoutVerify() };
			sslcontext.init((javax.net.ssl.KeyManager[]) null, trustManagersWithoutVerify, (SecureRandom) null);
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		return sslcontext;
	}

}
