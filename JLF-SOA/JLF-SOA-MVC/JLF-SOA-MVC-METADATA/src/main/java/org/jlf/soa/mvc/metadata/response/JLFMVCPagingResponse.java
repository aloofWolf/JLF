package org.jlf.soa.mvc.metadata.response;

import java.util.List;
import java.util.Map;

import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: JLFMVCPagingResponse
 * @Description:��ҳ������Ӧ�����Ĺ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public class JLFMVCPagingResponse<BEAN extends JLFMVCEntity> {

	private Long totalNum; // ������
	private Integer totalPage; // ��ҳ��
	private Map<String, Object> totField;// ���������ֶ�
	private List<BEAN> details; // ��ϸ

	public JLFMVCPagingResponse(Long totalNum, Integer totalPage, Map<String, Object> totField, List<BEAN> details) {
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.totField = totField;
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

	public Map<String, Object> getTotField() {
		return totField;
	}

	public void setTotField(Map<String, Object> totField) {
		this.totField = totField;
	}

	public List<BEAN> getDetails() {
		return details;
	}

	public void setDetails(List<BEAN> details) {
		this.details = details;
	}

}
