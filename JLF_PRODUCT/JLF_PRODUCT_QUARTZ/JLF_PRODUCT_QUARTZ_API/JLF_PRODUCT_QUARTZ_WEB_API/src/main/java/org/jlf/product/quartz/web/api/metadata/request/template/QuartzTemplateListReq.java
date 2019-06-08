package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzTemplateListReq
 * @Description:��ѯ��ʱ����ģ����Ϣ�б�����Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��6��1��
 */
public class QuartzTemplateListReq extends JLFMVCRequest{

	private String templateName; // ģ������
	private BooleanType enabled; // �Ƿ�����

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

}
