package org.jlf.plugin.push.test.http.config;

import org.jlf.plugin.push.user.api.config.JLFPushHttpConfig;

/**
 * 
 * @ClassName: HttpConfig
 * @Description: HttpConfig
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ11ÈÕ
 */
public class HttpConfig extends JLFPushHttpConfig {

	private String hostName;
	private String url;

	public HttpConfig(String hostName, String url) {
		this.hostName = hostName;
		this.url = url;
	}

	@Override
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
