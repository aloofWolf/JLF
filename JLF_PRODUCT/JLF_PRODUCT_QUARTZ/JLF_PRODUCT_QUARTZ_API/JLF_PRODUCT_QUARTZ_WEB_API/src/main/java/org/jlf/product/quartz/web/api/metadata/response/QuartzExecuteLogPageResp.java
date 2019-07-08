package org.jlf.product.quartz.web.api.metadata.response;

import java.util.List;

import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzExecuteLogPageResp
 * @Description:定时任务执行日志的分页详情响应参数
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class QuartzExecuteLogPageResp {

	private JLFMVCPagingResponse pages;
	private List<QuartzExecuteLogResp> details;

	public QuartzExecuteLogPageResp(Long totalNum, Integer totalPage, List<QuartzExecuteLogResp> details) {
		this.pages = new JLFMVCPagingResponse(totalNum, totalPage);
		this.details = details;
	}

	public JLFMVCPagingResponse getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingResponse pages) {
		this.pages = pages;
	}

	public List<QuartzExecuteLogResp> getDetails() {
		return details;
	}

	public void setDetails(List<QuartzExecuteLogResp> details) {
		this.details = details;
	}

}
