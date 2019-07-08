package org.jlf.product.quartz.web.api.metadata.response;

import java.util.List;

import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzTemplatePageResp
 * @Description:定时任务模板的分页详情响应参数
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class QuartzTemplatePageResp {

	private JLFMVCPagingResponse pages;
	private List<QuartzTemplateResp> details;

	public QuartzTemplatePageResp(Long totalNum, Integer totalPage, List<QuartzTemplateResp> details) {
		this.pages = new JLFMVCPagingResponse(totalNum, totalPage);
		this.details = details;
	}

	public JLFMVCPagingResponse getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingResponse pages) {
		this.pages = pages;
	}

	public List<QuartzTemplateResp> getDetails() {
		return details;
	}

	public void setDetails(List<QuartzTemplateResp> details) {
		this.details = details;
	}

}
