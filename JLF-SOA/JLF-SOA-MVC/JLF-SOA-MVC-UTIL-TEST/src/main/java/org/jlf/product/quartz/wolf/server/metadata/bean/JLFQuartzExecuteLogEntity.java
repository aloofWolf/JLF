package org.jlf.product.quartz.wolf.server.metadata.bean;

import java.util.Date;

import org.jlf.product.quartz.wolf.server.metadata.enums.JLFQuartzExecuteResult;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: QuartzExecuteLog
 * @Description:定时任务执行日志
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCBeanTableMapped(tableName = "QuartzExecuteLog",  desc = "定时任务执行日志表")
//@JLFMVCBeanTableMapped(tableName = "QuartzExecuteLog", dbName = "?", desc = "定时任务执行日志表")
public class JLFQuartzExecuteLogEntity extends JLFMVCEntity {

	private static final long serialVersionUID = -3872144041572860181L;
	@JLFMVCBeanFieldMapped(desc = "模板id")
	private Long templateId;
	@JLFMVCBeanFieldMapped(desc = "模板名称", strLength = 50)
	private String templateName;
	@JLFMVCBeanFieldMapped(desc = "模板的类名称", strLength = 100)
	private String templateClsName;
	@JLFMVCBeanFieldMapped(desc = "任务id")
	private Long jobId;
	@JLFMVCBeanFieldMapped(desc = "单据id", isNotNull = false)
	private Long billId;
	@JLFMVCBeanFieldMapped(desc = "执行参数", isNotNull = false)
	private String params;
	@JLFMVCBeanFieldMapped(desc = "执行开始时间")
	private Date startTime;
	@JLFMVCBeanFieldMapped(desc = "执行结束时间")
	private Date endTime;
	@JLFMVCBeanFieldMapped(desc = "执行结果")
	private JLFQuartzExecuteResult executeResult;
	@JLFMVCBeanFieldMapped(desc = "执行失败原因", isNotNull = false)
	private String failReason;

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

	public JLFQuartzExecuteResult getExecuteResult() {
		return executeResult;
	}

	public void setExecuteResult(JLFQuartzExecuteResult executeResult) {
		this.executeResult = executeResult;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((executeResult == null) ? 0 : executeResult.hashCode());
		result = prime * result + ((failReason == null) ? 0 : failReason.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((templateClsName == null) ? 0 : templateClsName.hashCode());
		result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
		result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JLFQuartzExecuteLogEntity other = (JLFQuartzExecuteLogEntity) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (executeResult != other.executeResult)
			return false;
		if (failReason == null) {
			if (other.failReason != null)
				return false;
		} else if (!failReason.equals(other.failReason))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (templateClsName == null) {
			if (other.templateClsName != null)
				return false;
		} else if (!templateClsName.equals(other.templateClsName))
			return false;
		if (templateId == null) {
			if (other.templateId != null)
				return false;
		} else if (!templateId.equals(other.templateId))
			return false;
		if (templateName == null) {
			if (other.templateName != null)
				return false;
		} else if (!templateName.equals(other.templateName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuartzExecuteLog [templateId=" + templateId + ", templateName=" + templateName + ", templateClsName="
				+ templateClsName + ", jobId=" + jobId + ", billId=" + billId + ", params=" + params + ", startTime="
				+ startTime + ", endTime=" + endTime + ", executeResult=" + executeResult + ", failReason=" + failReason
				+ ", toString()=" + super.toString() + "]";
	}

}
