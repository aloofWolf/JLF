package org.jlf.plugin.push.test.http.metadata;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

public class HttpTransRequest extends JLFPushRequest{
	
	private String reqType;
	@JLFCheckAnn(isNull=true)
	private Long templateId; 
	private String cron;
	private String templateName;
	private String clsName;
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
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	
	

}
