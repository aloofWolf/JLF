package org.jlf.product.quartz.web.api.metadata.response;

import java.util.Date;

/**
 * 
 * @ClassName: QuartzExecuteLogResp
 * @Description:��ʱ����ִ����־���б�������Ӧ����
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzExecuteLogResp {

	private Long templateId; // ģ��id
	private String templateName; // ģ������
	private String templateClsName; // ģ������
	private Long jobId; // ��ʱ����id
	private Long billId;// ����id
	private String params; // ִ�в���
	private Date startTime;// ��ʼִ��ʱ��
	private Date endTime; // ����ִ��ʱ��
	private Integer executeResult; // ִ�н��
	private String failReason; // ʧ��ԭ��

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
