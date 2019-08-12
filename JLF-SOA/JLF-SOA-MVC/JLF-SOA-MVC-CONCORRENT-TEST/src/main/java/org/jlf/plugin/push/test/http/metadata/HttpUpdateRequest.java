package org.jlf.plugin.push.test.http.metadata;

import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

public class HttpUpdateRequest extends JLFPushRequest{
	
	private Long id;
	private Long version;
	private String reqType;
	private Long templateId; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

}
