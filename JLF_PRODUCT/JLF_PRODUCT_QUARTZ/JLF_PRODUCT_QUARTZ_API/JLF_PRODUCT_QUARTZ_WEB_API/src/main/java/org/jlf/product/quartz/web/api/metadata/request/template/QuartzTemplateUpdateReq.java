package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzTemplateUpdateReq
 * @Description:���¶�ʱ����ģ������Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplateUpdateReq extends QuartzTemplateSaveReq {

	private JLFMVCIdAndVersionRequest header; // header��Ϣ

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
