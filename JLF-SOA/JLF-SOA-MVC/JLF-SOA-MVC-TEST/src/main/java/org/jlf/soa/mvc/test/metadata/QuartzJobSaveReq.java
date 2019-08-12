package org.jlf.soa.mvc.test.metadata;

import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
    * @ClassName: QuartzJobSaveReq
    * @Description: QuartzJobSave参数类
    * @author Lone Wolf
    * @date 2019年8月12日
 */
public class QuartzJobSaveReq extends JLFMVCRequest{
	
	private Long templateId; 
	private String cron;
	
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
