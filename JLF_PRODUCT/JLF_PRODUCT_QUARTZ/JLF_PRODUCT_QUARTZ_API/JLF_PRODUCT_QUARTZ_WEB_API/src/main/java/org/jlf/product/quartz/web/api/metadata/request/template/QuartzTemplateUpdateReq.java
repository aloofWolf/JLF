package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzTemplateUpdateReq
 * @Description:���¶�ʱ����ģ������Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplateUpdateReq extends JLFMVCIdAndVersionRequest {

	@JLFCheckAnn(isNull = true, desc = "ģ������")
	private String templateName;
	@JLFCheckAnn(isNull = true, desc = "ģ��������")
	private String clsName;
	@JLFCheckAnn(isNull = true, desc = "�Ƿ�����")
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

}
