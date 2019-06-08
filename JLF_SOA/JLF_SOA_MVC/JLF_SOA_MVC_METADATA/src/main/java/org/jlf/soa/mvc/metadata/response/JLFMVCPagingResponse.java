package org.jlf.soa.mvc.metadata.response;

import java.util.List;

/**
 * 
 * @ClassName: JLFMVCPagingResponse
 * @Description:��ҳ������Ӧ�����Ĺ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public final class JLFMVCPagingResponse {

	private Long totalNum; // ������
	private Integer totalPage; // ��ҳ��
	private Object other; // ������Ϣ
	private List<?> details; // ��ϸ

	public JLFMVCPagingResponse(Long totalNum, Integer totalPage, List<?> details) {
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.details = details;
	}

	public JLFMVCPagingResponse(Long totalNum, Integer totalPage, Object other, List<?> details) {
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.other = other;
		this.details = details;
	}

	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Object getOther() {
		return other;
	}

	public void setOther(Object other) {
		this.other = other;
	}

	public List<?> getDetails() {
		return details;
	}

	public void setDetails(List<?> details) {
		this.details = details;
	}

}
