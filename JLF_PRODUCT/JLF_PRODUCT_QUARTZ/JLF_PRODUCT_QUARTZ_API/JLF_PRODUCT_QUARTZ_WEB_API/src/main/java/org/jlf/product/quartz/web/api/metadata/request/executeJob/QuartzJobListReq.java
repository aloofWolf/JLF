package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzJobListReq
 * @Description:查询定时任务列表的参数信息
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public class QuartzJobListReq extends JLFMVCRequest {

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

}
