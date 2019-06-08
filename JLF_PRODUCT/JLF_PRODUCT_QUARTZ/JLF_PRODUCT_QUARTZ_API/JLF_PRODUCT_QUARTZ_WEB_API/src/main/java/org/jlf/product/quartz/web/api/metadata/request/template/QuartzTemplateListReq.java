package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzTemplateListReq
 * @Description:查询定时任务模板信息列表请求的参数信息
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public class QuartzTemplateListReq extends JLFMVCRequest{

	private String templateName; // 模板名称
	private BooleanType enabled; // 是否启用

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
