package org.jlf.product.quartz.web.api.metadata.entity;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.client.json.JLFJsonClient;
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
@JLFMVCBeanTableMapped(tableName = "QuartzJob", desc = "定时任务表")
public class JLFQuartzJobEntity extends JLFMVCEntity {

	private static final long serialVersionUID = -4226760968283776369L;
	@JLFCheckAnn(desc = "模板id")
	@JLFMVCBeanFieldMapped(desc = "模板id")
	private Long templateId;
	@JLFCheckAnn(desc = "任务组名称", isNull = true)
	@JLFMVCBeanFieldMapped(desc = "任务组名称", isNotNull = false)
	private String groupName;
	@JLFCheckAnn(desc = "执行时间表达式", maxLength = 20)
	@JLFMVCBeanFieldMapped(desc = "执行时间表达式", strLength = 20)
	private String cron;
	@JLFCheckAnn(desc = "是否启用", isNull = true)
	@JLFMVCBeanFieldMapped(desc = "是否启用", defaultValue = "0")
	private BooleanType enabled;
	@JLFCheckAnn(desc = "执行任务的主机ip", isNull = true)
	@JLFMVCBeanFieldMapped(desc = "执行任务的主机ip")
	private String hostIp;
	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(desc = "执行参数", isNotNull = false, strLength = 100)
	private String params;
	
	@JLFCheckAnn(desc = "执行参数",isNull = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)
	private Map<String,Object> paramsMap;

	@JLFCheckAnn(isSkipValidate = true)
	@JLFMVCBeanFieldMapped(isSkipMapped = true)
	private JLFQuartzTemplateEntity template;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
		if(paramsMap != null){
			this.params = JLFJsonClient.get().mapToJsonStr(paramsMap);
		}
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
		result = prime * result + ((cron == null) ? 0 : cron.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((hostIp == null) ? 0 : hostIp.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((template == null) ? 0 : template.hashCode());
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
		JLFQuartzJobEntity other = (JLFQuartzJobEntity) obj;
		if (cron == null) {
			if (other.cron != null)
				return false;
		} else if (!cron.equals(other.cron))
			return false;
		if (enabled != other.enabled)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (hostIp == null) {
			if (other.hostIp != null)
				return false;
		} else if (!hostIp.equals(other.hostIp))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
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
		return true;
	}

	@Override
	public String toString() {
		return "JLFQuartzJobEntity [templateId=" + templateId + ", groupName=" + groupName + ", cron=" + cron
				+ ", enabled=" + enabled + ", hostIp=" + hostIp + ", params=" + params + ", template=" + template
				+ ", toString()=" + super.toString() + "]";
	}

}
