package org.jlf.soa.mvc.test.metadata;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzJobUpdateReq
 * @Description:QuartzJobUpdateReq
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ12ÈÕ
 */
public class QuartzJobUpdateReq extends JLFMVCIdAndVersionRequest {

	private Long templateId;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

}
