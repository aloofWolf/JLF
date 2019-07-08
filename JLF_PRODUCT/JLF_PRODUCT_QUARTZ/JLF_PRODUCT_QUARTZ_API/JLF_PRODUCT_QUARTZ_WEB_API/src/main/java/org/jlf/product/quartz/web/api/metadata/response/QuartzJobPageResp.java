package org.jlf.product.quartz.web.api.metadata.response;

import java.util.List;

import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzJobPageResp
 * @Description:定时任务的分页详情响应参数
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class QuartzJobPageResp {

	private JLFMVCPagingResponse pages;
	private List<QuartzJobResp> details;

	public QuartzJobPageResp(Long totalNum, Integer totalPage, List<QuartzJobResp> details) {
		this.pages = new JLFMVCPagingResponse(totalNum, totalPage);
		this.details = details;
	}

	public JLFMVCPagingResponse getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingResponse pages) {
		this.pages = pages;
	}

	public List<QuartzJobResp> getDetails() {
		return details;
	}

	public void setDetails(List<QuartzJobResp> details) {
		this.details = details;
	}

}
