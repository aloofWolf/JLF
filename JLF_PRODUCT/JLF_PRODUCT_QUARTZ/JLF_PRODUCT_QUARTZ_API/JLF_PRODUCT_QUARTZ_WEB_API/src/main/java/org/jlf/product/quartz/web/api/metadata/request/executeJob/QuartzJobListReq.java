package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzJobListReq
 * @Description:��ѯ��ʱ�����б�Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��6��1��
 */
public class QuartzJobListReq extends JLFMVCRequest{

	private Long templateId; // ģ��id
	private String templateName; // ģ������
	private Long billId; // ����id
	private BooleanType enabled; // �Ƿ�����

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

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

}
