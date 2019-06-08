package org.jlf.product.quartz.web.api.metadata.request.executeLog;

import java.util.Date;

import org.jlf.product.quartz.web.api.metadata.enums.QuartzExecuteResult;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzExecuteLogPageReq
 * @Description:查询定时任务执行日志分页请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzExecuteLogPageReq extends JLFMVCRequest{

	private JLFMVCPagingRequest pages;
	private Long templateId; // 模板id
	private String templateName; // 模板名称
	private Long jobId; // 任务id
	private Long billId; // 单据id
	private Date startTime; // 执行开始时间
	private Date endTime; // 执行结束时间
	private QuartzExecuteResult executeResult; // 执行结果
	private String failReason; // 失败原因

	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}

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

	public QuartzExecuteResult getExecuteResult() {
		return executeResult;
	}

	public void setExecuteResult(QuartzExecuteResult executeResult) {
		this.executeResult = executeResult;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

}
