package org.jlf.product.quartz.web.api.metadata.request;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzTemplatePageReq
 * @Description:查询定时任务模板信息分页请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class JLFQuartzTemplatePageReq {

	@JLFCheckAnn(desc = "分页信息")
	private JLFMVCPagingRequest pages;

	@JLFCheckAnn(isNull = true, desc = "模板名称")
	private String templateName;
	@JLFCheckAnn(isNull = true, desc = "模板名称")
	private String templateClsName;
	@JLFCheckAnn(isNull = true, desc = "是否启用")
	private BooleanType enabled;
	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateClsName() {
		return templateClsName;
	}

	public void setTemplateClsName(String templateClsName) {
		this.templateClsName = templateClsName;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}
	
}
