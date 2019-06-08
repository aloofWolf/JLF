package org.jlf.soa.mvc.metadata.response;

import java.util.List;

/**
 * 
 * @ClassName: JLFMVCPagingResponse
 * @Description:分页请求响应参数的公共信息
 * @author Lone Wolf
 * @date 2019年5月25日
 */
public final class JLFMVCPagingResponse {

	private Long totalNum; // 总条数
	private Integer totalPage; // 总页数
	private Object other; // 其它信息
	private List<?> details; // 明细

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
