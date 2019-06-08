package org.jlf.product.quartz.wolf.server.metadata.bean;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBeanMapped;

/**
 * 
 * @ClassName: QuartzExecute
 * @Description:定时任务bean
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCBeanMapped(dbName = "?")
public class QuartzJob extends JLFMVCBean {

	private static final long serialVersionUID = -4226760968283776369L;
	private Long templateId; // 模板id
	private Long billId; // 管理单据id,可为空
	private String cron; // 执行时间
	private BooleanType enabled; // 是否启用
	private BooleanType ready;// 是否就绪
	private String params;// 执行参数

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
