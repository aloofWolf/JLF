package org.jlf.plugin.push.test.http.metadata;

import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: HttpRequest
 * @Description:HttpRequest
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class HttpRequest extends JLFPushRequest {

	private String reqType;
	private Long id;

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
