package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzTemplatePageReq
 * @Description:查询定时任务模板信息分页请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
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
