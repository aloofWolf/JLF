package org.jlf.soa.mvc.test.metadata;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzJobTransReq
 * @Description:QuartzJobTransReq
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ12ÈÕ
 */
public class QuartzJobTransReq extends JLFMVCRequest {

	@JLFCheckAnn(isNull = true)
	private Long templateId;
	private String cron;
	private String templateName;
	private String clsName;

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
