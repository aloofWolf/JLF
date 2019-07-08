package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzTemplateUpdateReq
 * @Description:更新定时任务模板请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzTemplateUpdateReq extends JLFMVCIdAndVersionRequest {

	@JLFCheckAnn(isNull = true, desc = "模板名称")
	private String templateName;
	@JLFCheckAnn(isNull = true, desc = "模板类名称")
	private String clsName;
	@JLFCheckAnn(isNull = true, desc = "是否启用")
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
