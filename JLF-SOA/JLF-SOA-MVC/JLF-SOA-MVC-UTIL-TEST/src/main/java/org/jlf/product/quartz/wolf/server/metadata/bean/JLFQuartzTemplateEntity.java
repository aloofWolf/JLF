package org.jlf.product.quartz.wolf.server.metadata.bean;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: QuartzTemplate
 * @Description:��ʱ����ģ��
 * @author Lone Wolf
 * @date 2019��5��31��
 */
@JLFMVCBeanTableMapped(tableName="QuartzTemplate", desc = "��ʱ����ģ���")
//@JLFMVCBeanTableMapped(tableName="QuartzTemplate",dbName = "?", desc = "��ʱ����ģ���")
public class JLFQuartzTemplateEntity extends JLFMVCEntity {

	private static final long serialVersionUID = -1968380561688821868L;
	@JLFCheckAnn(desc = "ģ������", maxLength = 50)
	@JLFMVCBeanFieldMapped(desc = "ģ������", isUnique = true, uniqueName = "templateNameUnique", joinUniqueField = "deleteNum", strLength = 50)
	private String templateName;
	@JLFCheckAnn(desc = "ģ�������", maxLength = 100)
	@JLFMVCBeanFieldMapped(desc = "ģ�������", strLength = 100)
	private String clsName;
	@JLFCheckAnn(desc = "�Ƿ�����",isNull = true)
	@JLFMVCBeanFieldMapped(desc = "�Ƿ�����",defaultValue="0")
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
