package org.jlf.product.quartz.web.api.metadata.response;

import java.util.Date;

/**
 * 
 * @ClassName: QuartzExecuteLogResp
 * @Description:定时任务执行日志的列表详情响应参数
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzExecuteLogResp {

	private Long templateId; // 模板id
	private String templateName; // 模板名称
	private String templateClsName; // 模板类名
	private Long jobId; // 定时任务id
	private Long billId;// 单据id
	private String params; // 执行参数
	private Date startTime;// 开始执行时间
	private Date endTime; // 结束执行时间
	private Integer executeResult; // 执行结果
	private String failReason; // 失败原因

	/*public QuartzExecuteLogResp(QuartzExecuteLog log) {
		this.templateId = log.getTemplateId();
		this.templateName = log.getTemplateName();
		this.templateClsName = log.getTemplateClsName();
		this.jobId = log.getJobId();
		this.billId = log.getBillId();
		this.params = log.getParams();
		this.startTime = log.getStartTime();
		this.endTime = log.getEndTime();
		this.executeResult = log.getExecuteResult().getId();
		this.failReason = log.getFailReason();
	}*/

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateClsName() {
		return templateClsName;
	}

	public void setTemplateClsName(String templateClsName) {
		this.templateClsName = templateClsName;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getExecuteResult() {
		return executeResult;
	}

	public void setExecuteResult(Integer executeResult) {
		this.executeResult = executeResult;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

}
