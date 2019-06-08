package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.user.api.JLFJob;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzTemplateSaveReq
 * @Description:������ʱ����ģ������Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplateSaveReq extends JLFMVCRequest{

	private String templateName; // ģ������
	private String clsName; // ģ��������
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

	public void setClsName(String clsName) throws Exception {
		try {
			Class<?> jobCls = Class.forName(clsName);
			if (!JLFJob.class.isAssignableFrom(jobCls)) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("ģ����������ȷ");
		}
		this.clsName = clsName;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

}

/**
 * 
 * @Title: getTemplate
 * @Description:template
 * @return
 *//*
public QuartzTemplate getTemplate() {
	QuartzTemplate template = new QuartzTemplate();
	template.setTemplateName(this.templateName);
	template.setClsName(this.clsName);
	template.setEnabled(this.enabled);
	return template;
}*/
