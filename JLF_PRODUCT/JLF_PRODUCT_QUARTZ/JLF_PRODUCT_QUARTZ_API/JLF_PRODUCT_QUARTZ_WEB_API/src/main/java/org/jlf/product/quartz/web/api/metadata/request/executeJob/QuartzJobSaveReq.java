package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzExecuteSaveReq
 * @Description:新增定时任务请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobSaveReq extends JLFMVCRequest {

	@JLFCheckAnn(desc = "模板id")
	private Long templateId;
	@JLFCheckAnn(isNull = true, desc = "单据id")
	private Long billId;
	@JLFCheckAnn(maxLength = 20, desc = "执行时间")
	private String core;
	@JLFCheckAnn(desc = "是否启用")
	private BooleanType enabled;
	@JLFCheckAnn(isNull = true, desc = "执行参数")
	private Map<String, Object> params;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public BooleanType getEnabled() {
		return enabled;
	}

	public void setEnabled(BooleanType enabled) {
		this.enabled = enabled;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
