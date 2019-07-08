package org.jlf.plugin.dbPool.wolf.server.config;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: DbWolfConfig
 * @Description:DbWolf��������
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public class DbPoolWolfMainConfig {

	@JLFCheckAnn
	private String driver;
	@JLFCheckAnn
	private String url;
	@JLFCheckAnn
	private String userName;
	@JLFCheckAnn
	private String password;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

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
