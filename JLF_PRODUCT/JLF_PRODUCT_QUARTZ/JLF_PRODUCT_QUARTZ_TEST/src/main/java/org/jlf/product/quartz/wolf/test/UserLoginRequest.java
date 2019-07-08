package org.jlf.product.quartz.wolf.test;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

public class UserLoginRequest extends JLFMVCRequest{
	
    @JLFCheckAnn
	private Long userId;
    @JLFCheckAnn
	private String userName;
    @JLFCheckAnn
	private String dbName;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	
}
