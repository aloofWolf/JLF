package org.jlf.product.quartz.web.api.metadata.request;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzExecutePageReq
 * @Description:查询定时任务分页请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class JLFQuartzJobPageReq {

	@JLFCheckAnn(desc = "分页信息")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(isNull = true, desc = "模板id")
	private Long templateId;
	@JLFCheckAnn(isNull = true, desc = "模板名称")
	private String templateName;
	@JLFCheckAnn(isNull = true, desc = "单据id")
	private Long billId;
	@JLFCheckAnn(isNull = true, desc = "是否启用")
	private BooleanType enabled;

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

	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}
}
