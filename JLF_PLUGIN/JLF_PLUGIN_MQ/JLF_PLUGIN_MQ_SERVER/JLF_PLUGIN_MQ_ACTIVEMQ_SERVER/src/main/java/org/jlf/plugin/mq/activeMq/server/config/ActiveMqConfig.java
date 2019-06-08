package org.jlf.plugin.mq.activeMq.server.config;

/**
 * 
 * @ClassName: ActiveMqConfig
 * @Description:ActiveMq配置
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ActiveMqConfig {

	private String url; // url
	private String userName; // 用户名
	private String password; // 密码

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
