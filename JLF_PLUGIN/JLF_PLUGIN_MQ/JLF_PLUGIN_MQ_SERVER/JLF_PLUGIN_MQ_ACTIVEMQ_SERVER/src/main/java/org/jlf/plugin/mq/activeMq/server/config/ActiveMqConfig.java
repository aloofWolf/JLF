package org.jlf.plugin.mq.activeMq.server.config;

/**
 * 
 * @ClassName: ActiveMqConfig
 * @Description:ActiveMq����
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class ActiveMqConfig {

	private String url; // url
	private String userName; // �û���
	private String password; // ����

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
