package org.jlf.soa.mvc.metadata.request;

/**
 * 
 * @ClassName: JLFMVCPagingRequest
 * @Description:��ҳ�������������Ϣ
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public final class JLFMVCPagingRequest{

	private Integer pageNum; // ��ǰҳ��
	private Integer pageSize; // ÿҳ��ʾ����
	
	

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
