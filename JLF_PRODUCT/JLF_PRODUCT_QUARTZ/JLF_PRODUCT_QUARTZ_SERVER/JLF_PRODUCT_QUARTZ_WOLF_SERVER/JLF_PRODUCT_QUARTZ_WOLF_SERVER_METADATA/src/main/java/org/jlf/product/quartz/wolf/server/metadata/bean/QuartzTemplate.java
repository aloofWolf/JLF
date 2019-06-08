package org.jlf.product.quartz.wolf.server.metadata.bean;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBeanMapped;

/**
 * 
 * @ClassName: QuartzTemplate
 * @Description:��ʱ����ģ��
 * @author Lone Wolf
 * @date 2019��5��31��
 */
@JLFMVCBeanMapped(dbName = "?")
public class QuartzTemplate extends JLFMVCBean {

	private static final long serialVersionUID = -1968380561688821868L;
	private String templateName; // ģ������
	private String clsName; // ģ�������
	private BooleanType enabled; // �Ƿ�����

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
		QuartzTemplate other = (QuartzTemplate) obj;
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
