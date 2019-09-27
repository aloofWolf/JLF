package org.jlf.product.quartz.wolf.server.metadata.bean;

import java.util.Date;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: QuartzExecute
 * @Description:定时任务bean
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCBeanTableMapped(tableName="QuartzJob",desc = "定时任务表")
//@JLFMVCBeanTableMapped(tableName="QuartzJob",dbName = "?", desc = "定时任务表")
public class JLFQuartzJobEntity extends JLFMVCEntity {

	private static final long serialVersionUID = -4226760968283776369L;
	@JLFCheckAnn(desc = "模板id")
	@JLFMVCBeanFieldMapped(desc = "模板id")
	private Long templateId;
	@JLFCheckAnn(desc = "单据id", isNull = true)
	@JLFMVCBeanFieldMapped(desc = "单据id", isNotNull = false)
	private Long billId;
	@JLFCheckAnn(desc = "执行时间表达式", maxLength = 20)
	@JLFMVCBeanFieldMapped(desc = "执行时间表达式", strLength = 20)
	private String cron;
	@JLFCheckAnn(desc = "是否启用",isNull = true)
	@JLFMVCBeanFieldMapped(desc = "是否启用",defaultValue="0")
	private BooleanType enabled;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "是否正在运行",defaultValue="1")
	private BooleanType running;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "上一次执行时间", isNotNull = false)
	private Date lastExecuteTime;
	@JLFCheckAnn(desc = "执行超时时间")
	@JLFMVCBeanFieldMapped(desc = "执行超时时间")
	private Long timeOut;
	@JLFCheckAnn(desc = "执行参数", isNull = true)
	@JLFMVCBeanFieldMapped(desc = "执行参数", isNotNull = false, strLength = 100)
	private String params;

	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)
	private JLFQuartzTemplateEntity template;

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

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

	public BooleanType getRunning() {
		return running;
	}

	public void setRunning(BooleanType running) {
		this.running = running;
	}

	public Date getLastExecuteTime() {
		return lastExecuteTime;
	}

	public void setLastExecuteTime(Date lastExecuteTime) {
		this.lastExecuteTime = lastExecuteTime;
	}

	public Long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Long timeOut) {
		this.timeOut = timeOut;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public JLFQuartzTemplateEntity getTemplate() {
		return template;
	}

	public void setTemplate(JLFQuartzTemplateEntity template) {
		this.template = template;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((cron == null) ? 0 : cron.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((lastExecuteTime == null) ? 0 : lastExecuteTime.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((running == null) ? 0 : running.hashCode());
		result = prime * result + ((template == null) ? 0 : template.hashCode());
		result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
		result = prime * result + ((timeOut == null) ? 0 : timeOut.hashCode());
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
		JLFQuartzJobEntity other = (JLFQuartzJobEntity) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (cron == null) {
			if (other.cron != null)
				return false;
		} else if (!cron.equals(other.cron))
			return false;
		if (enabled != other.enabled)
			return false;
		if (lastExecuteTime == null) {
			if (other.lastExecuteTime != null)
				return false;
		} else if (!lastExecuteTime.equals(other.lastExecuteTime))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (running != other.running)
			return false;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.equals(other.template))
			return false;
		if (templateId == null) {
			if (other.templateId != null)
				return false;
		} else if (!templateId.equals(other.templateId))
			return false;
		if (timeOut == null) {
			if (other.timeOut != null)
				return false;
		} else if (!timeOut.equals(other.timeOut))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JLFQuartzJobEntity [templateId=" + templateId + ", billId=" + billId + ", cron=" + cron + ", enabled="
				+ enabled + ", running=" + running + ", lastExecuteTime=" + lastExecuteTime
				+ ", timeOut=" + timeOut + ", params=" + params + ", template=" + template + ", toString()="
				+ super.toString() + "]";
	}

}
