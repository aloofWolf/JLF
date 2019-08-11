package org.jlf.soa.mvc.metadata.page;

import java.util.List;
import java.util.Map;

import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: JLFMVCPage
 * @Description:MVC分页信息
 * @author Lone Wolf
 * @date 2019年5月31日
 * @param <BEAN>
 */
public class JLFMVCPage<BEAN extends JLFMVCEntity> {

	private Long totalNum; // 总条数
	private Integer totalPage; // 总页数
	private Map<String, Object> totField;// 其它汇总字段
	private List<BEAN> details; // 明细

	public JLFMVCPage(Long totalNum, Integer totalPage, Map<String, Object> totField, List<BEAN> details) {
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
