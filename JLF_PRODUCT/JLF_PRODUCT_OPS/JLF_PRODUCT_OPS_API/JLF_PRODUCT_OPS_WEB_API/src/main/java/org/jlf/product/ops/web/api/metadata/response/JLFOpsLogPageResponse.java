package org.jlf.product.ops.web.api.metadata.response;

import java.util.List;

import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFOpsLogPageResponse
 * @Description:opsLog分页查询响应信息
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class JLFOpsLogPageResponse {

	private JLFMVCPagingResponse pages; // 分页信息
	private List<JLFOpsLogPageDetailResponse> details; // 列表明细

	public JLFOpsLogPageResponse(Long totalNum, Integer totalPage, List<JLFOpsLogPageDetailResponse> details) {
		this.pages = new JLFMVCPagingResponse(totalNum, totalPage);
		this.details = details;
	}

	public JLFMVCPagingResponse getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingResponse pages) {
		this.pages = pages;
	}

	public List<JLFOpsLogPageDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<JLFOpsLogPageDetailResponse> details) {
		this.details = details;
	}

}
