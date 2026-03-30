package jlf.web.session.bean;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @ClassName: UserSession
 * @Description: 用户的session信息
 * @author Lone Wolf
 * @param <T>
 * @date 2019年9月10日
 */
@Getter
@ToString
public class UserSession<T> implements Serializable {

	private static final long serialVersionUID = -4832274719336557204L;
	private Long userId; // 用户id
	private String userName; // 用户名称
	
	private T obj; // 其它信息
	
	public UserSession(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public UserSession(Long userId, String userName,T obj) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.obj = obj;
	}

}
