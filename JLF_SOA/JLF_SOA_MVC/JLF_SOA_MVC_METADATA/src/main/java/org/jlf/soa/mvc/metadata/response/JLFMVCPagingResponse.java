package org.jlf.soa.mvc.metadata.response;

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

	public JLFMVCPagingResponse(Long totalNum, Integer totalPage) {
		this.totalNum = totalNum;
		this.totalPage = totalPage;
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

}
