package org.jlf.plugin.session.user.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFSessionBean
 * @Description:session中保存的实体信息,需调用者继承此类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class JLFSessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId; // 用户id

	private String userName; // 用户名称

	private String dbName; // 数据库名称

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

	@Override
	public String toString() {
		return "JLFSessionBean [userId=" + userId + ", userName=" + userName + ", dbName=" + dbName + "]";
	}
	
	

}
