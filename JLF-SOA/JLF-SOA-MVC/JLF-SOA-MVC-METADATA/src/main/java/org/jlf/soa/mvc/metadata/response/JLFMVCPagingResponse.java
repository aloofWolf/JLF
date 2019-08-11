package org.jlf.soa.mvc.metadata.response;

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
