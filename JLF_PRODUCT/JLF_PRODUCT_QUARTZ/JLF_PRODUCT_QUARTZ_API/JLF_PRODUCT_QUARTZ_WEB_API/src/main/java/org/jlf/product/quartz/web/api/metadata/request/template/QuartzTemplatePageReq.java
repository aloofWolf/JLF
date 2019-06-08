package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzTemplatePageReq
 * @Description:��ѯ��ʱ����ģ����Ϣ��ҳ����Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplatePageReq extends QuartzTemplateListReq {

	private JLFMVCPagingRequest pages;

	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}
}
