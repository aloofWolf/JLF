package org.jlf.plugin.push.user.api.config;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 
 * @ClassName: JLFX509TrustManagerWithoutVerify
 * @Description:�ƹ�֤����֤��X509TrustManagerʵ��
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class JLFX509TrustManagerWithoutVerify implements X509TrustManager {

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
