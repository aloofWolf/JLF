package org.jlf.plugin.push.user.api.config;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 
 * @ClassName: JLFX509TrustManagerWithoutVerify
 * @Description:绕过证书验证的X509TrustManager实现
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class JLFX509TrustManagerWithoutVerify implements X509TrustManager {
	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
