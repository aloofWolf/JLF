package org.jlf.plugin.push.user.api.config;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 
 * @ClassName: JLFPushX509TrustManagerWithoutVerify
 * @Description:绕过证书验证的X509TrustManager实现
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class JLFPushX509TrustManagerWithoutVerify implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) {

	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) {

	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
