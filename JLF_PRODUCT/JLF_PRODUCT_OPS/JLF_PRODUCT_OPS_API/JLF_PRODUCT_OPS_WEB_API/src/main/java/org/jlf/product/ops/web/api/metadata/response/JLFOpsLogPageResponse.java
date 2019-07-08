package org.jlf.product.ops.web.api.metadata.response;

import java.util.List;

import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFOpsLogPageResponse
 * @Description:opsLog��ҳ��ѯ��Ӧ��Ϣ
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class JLFOpsLogPageResponse {

	private JLFMVCPagingResponse pages; // ��ҳ��Ϣ
	private List<JLFOpsLogPageDetailResponse> details; // �б���ϸ

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
