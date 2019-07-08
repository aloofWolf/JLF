package org.jlf.product.quartz.web.api.metadata.request.executeLog;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
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
public class QuartzExecuteLogPageReq extends JLFMVCRequest {

	@JLFCheckAnn(desc = "��ҳ��Ϣ")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(isNull = true, desc = "ģ��id")
	private Long templateId;
	@JLFCheckAnn(isNull = true, desc = "ģ������")
	private String templateName;
	@JLFCheckAnn(isNull = true, desc = "����id")
	private Long jobId;
	@JLFCheckAnn(isNull = true, desc = "����id")
	private Long billId;
	@JLFCheckAnn(isNull = true, desc = "ִ�п�ʼʱ��")
	private Date startTime;
	@JLFCheckAnn(isNull = true, desc = "ִ�н���ʱ��")
	private Date endTime;
	@JLFCheckAnn(isNull = true, desc = "ִ�н��")
	private QuartzExecuteResult executeResult;
	@JLFCheckAnn(isNull = true, desc = "ʧ��ԭ��")
	private String failReason;

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
