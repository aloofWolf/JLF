package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: QuartzExecuteSaveReq
 * @Description:新增定时任务请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobSaveReq extends JLFMVCRequest{

	private Long templateId; // 模板id
	private Long billId; // 单据id
	private String core; // 执行时间
	private BooleanType enabled; // 是否启用
	private JSONObject params; // 执行参数

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

	public JSONObject getParams() {
		return params;
	}

	public void setParams(JSONObject params) {
		this.params = params;
	}

}

/**
 * 
 * @Title: getBeanList
 * @Description:获取QuartzExecute的list
 * @return
 *//*
	 * public List<QuartzJob> getBeanList() { List<QuartzJob> list = new
	 * ArrayList<QuartzJob>(); for (QuartzJobSaveDetailReq detail : details) {
	 * QuartzJob job = new QuartzJob(); job.setTemplateId(this.templateId);
	 * job.setBillId(this.billId); job.setCron(detail.getCore());
	 * job.setEnabled(detail.getEnabled()); if
	 * (detail.getEnabled().equals(BooleanType.TRUE)) {
	 * job.setReady(BooleanType.TRUE); } if (detail.getParams() != null) {
	 * job.setParams(detail.getParams().toJSONString()); } list.add(job); }
	 * return list; }
	 */
