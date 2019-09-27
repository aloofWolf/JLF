package org.jlf.product.quartz.wolf.server.metadata.bean;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: QuartzTemplate
 * @Description:定时任务模板
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCBeanTableMapped(tableName="QuartzTemplate", desc = "定时任务模板表")
//@JLFMVCBeanTableMapped(tableName="QuartzTemplate",dbName = "?", desc = "定时任务模板表")
public class JLFQuartzTemplateEntity extends JLFMVCEntity {

	private static final long serialVersionUID = -1968380561688821868L;
	@JLFCheckAnn(desc = "模板名称", maxLength = 50)
	@JLFMVCBeanFieldMapped(desc = "模板名称", isUnique = true, uniqueName = "templateNameUnique", joinUniqueField = "deleteNum", strLength = 50)
	private String templateName;
	@JLFCheckAnn(desc = "模板的类名", maxLength = 100)
	@JLFMVCBeanFieldMapped(desc = "模板的类名", strLength = 100)
	private String clsName;
	@JLFCheckAnn(desc = "是否启用",isNull = true)
	@JLFMVCBeanFieldMapped(desc = "是否启用",defaultValue="0")
	private BooleanType enabled;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((clsName == null) ? 0 : clsName.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
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
		JLFQuartzTemplateEntity other = (JLFQuartzTemplateEntity) obj;
		if (clsName == null) {
			if (other.clsName != null)
				return false;
		} else if (!clsName.equals(other.clsName))
			return false;
		if (enabled != other.enabled)
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
		return "QuartzTemplate [templateName=" + templateName + ", clsName=" + clsName + ", enabled=" + enabled
				+ ", toString()=" + super.toString() + "]";
	}

}
