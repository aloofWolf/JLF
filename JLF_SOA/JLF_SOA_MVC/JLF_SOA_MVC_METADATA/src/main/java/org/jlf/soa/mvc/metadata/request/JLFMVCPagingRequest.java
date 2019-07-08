package org.jlf.soa.mvc.metadata.request;

/**
 * 
 * @ClassName: JLFMVCPagingRequest
 * @Description:分页请求参数公共信息
 * @author Lone Wolf
 * @date 2019年5月25日
 */
public final class JLFMVCPagingRequest{

	private Integer pageNum; // 当前页码
	private Integer pageSize; // 每页显示条数
	
	

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
