package org.jlf.soa.mvc.test.bean;

import org.jlf.common.enums.BooleanType;
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
@JLFMVCBeanTableMapped(desc = "定时任务表",cache=true)
public class QuartzJob extends JLFMVCEntity {

	private static final long serialVersionUID = -4226760968283776369L;
	@JLFMVCBeanFieldMapped(desc = "模板id")
	private Long templateId;
	@JLFMVCBeanFieldMapped(desc = "单据id",isNotNull = false)
	private Long billId;
	@JLFMVCBeanFieldMapped(desc = "执行时间表达式",strLength = 20)
	private String cron;
	@JLFMVCBeanFieldMapped(desc = "是否启用")
	private BooleanType enabled;
	@JLFMVCBeanFieldMapped(desc = "是否就绪")
	private BooleanType ready;
	@JLFMVCBeanFieldMapped(desc = "执行参数",isNotNull = false,strLength = 100)
	private String params;

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

	public BooleanType getReady() {
		return ready;
	}

	public void setReady(BooleanType ready) {
		this.ready = ready;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((cron == null) ? 0 : cron.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((ready == null) ? 0 : ready.hashCode());
		result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
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
		QuartzJob other = (QuartzJob) obj;
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
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (ready != other.ready)
			return false;
		if (templateId == null) {
			if (other.templateId != null)
				return false;
		} else if (!templateId.equals(other.templateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuartzExecute [templateId=" + templateId + ", billId=" + billId + ", cron=" + cron + ", enabled="
				+ enabled + ", ready=" + ready + ", params=" + params + ", toString()=" + super.toString() + "]";
	}
}
