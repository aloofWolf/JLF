package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzTemplateUpdateReq
 * @Description:更新定时任务模板请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzTemplateUpdateReq extends QuartzTemplateSaveReq {

	private JLFMVCIdAndVersionRequest header; // header信息

	public JLFMVCIdAndVersionRequest getHeader() {
		return header;
	}

	public void setHeader(JLFMVCIdAndVersionRequest header) {
		this.header = header;
	}
	
	

	/**
	 * 
	 * @Title: getTemplate
	 * @Description:template
	 * @return
	 *//*
	public QuartzTemplate getTemplate() {
		QuartzTemplate template = super.getTemplate();
		template.setId(header.getId());
		template.setVersion(header.getVersion());
		return template;
	}*/

}
