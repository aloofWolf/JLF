package org.jlf.plugin.push.test.http.metadata;

import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

public class HttpSaveRequest extends JLFPushRequest{
	
	private String reqType;
	private Long templateId; 
	private String cron;
	
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
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}

}
