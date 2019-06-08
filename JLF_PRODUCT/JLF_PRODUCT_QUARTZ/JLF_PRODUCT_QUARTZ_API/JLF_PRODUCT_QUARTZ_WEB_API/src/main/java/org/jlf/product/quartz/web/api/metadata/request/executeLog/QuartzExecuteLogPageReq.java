package org.jlf.product.quartz.web.api.metadata.request.executeLog;

import java.util.Date;

import org.jlf.product.quartz.web.api.metadata.enums.QuartzExecuteResult;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzExecuteLogPageReq
 * @Description:��ѯ��ʱ����ִ����־��ҳ����Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzExecuteLogPageReq extends JLFMVCRequest{

	private JLFMVCPagingRequest pages;
	private Long templateId; // ģ��id
	private String templateName; // ģ������
	private Long jobId; // ����id
	private Long billId; // ����id
	private Date startTime; // ִ�п�ʼʱ��
	private Date endTime; // ִ�н���ʱ��
	private QuartzExecuteResult executeResult; // ִ�н��
	private String failReason; // ʧ��ԭ��

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
