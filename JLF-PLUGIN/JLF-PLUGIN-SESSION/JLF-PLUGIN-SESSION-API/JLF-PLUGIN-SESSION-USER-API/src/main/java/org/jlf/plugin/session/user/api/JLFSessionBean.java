package org.jlf.plugin.session.user.api;

import java.io.Serializable;

/**
 * 
 * @ClassName: JLFSessionBean
 * @Description:session�б����ʵ����Ϣ,������߼̳д���
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class JLFSessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId; // �û�id

	private String userName; // �û�����

	private String dbName; // ���ݿ�����

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
