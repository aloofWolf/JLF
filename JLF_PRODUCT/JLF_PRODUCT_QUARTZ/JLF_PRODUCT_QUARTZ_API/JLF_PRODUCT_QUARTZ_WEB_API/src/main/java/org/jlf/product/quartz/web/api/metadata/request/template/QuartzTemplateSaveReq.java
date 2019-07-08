package org.jlf.product.quartz.web.api.metadata.request.template;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.product.quartz.user.api.JLFJob;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: QuartzTemplateSaveReq
 * @Description:新增定时任务模板请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzTemplateSaveReq extends JLFMVCRequest {

	@JLFCheckAnn(desc = "模板名称")
	private String templateName;
	@JLFCheckAnn(desc = "模板类名称")
	private String clsName;
	@JLFCheckAnn(desc = "是否启用")
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

	public void setClsName(String clsName) throws Exception {
		try {
			Class<?> jobCls = Class.forName(clsName);
			if (!JLFJob.class.isAssignableFrom(jobCls)) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("模板类名不正确");
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
