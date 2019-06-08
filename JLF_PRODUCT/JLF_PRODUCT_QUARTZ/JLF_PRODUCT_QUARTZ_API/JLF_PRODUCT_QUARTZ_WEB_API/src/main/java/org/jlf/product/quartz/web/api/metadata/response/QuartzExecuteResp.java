package org.jlf.product.quartz.web.api.metadata.response;

/**
 * 
 * @ClassName: QuartzExecuteResp
 * @Description:定时任务的列表详情响应参数
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzExecuteResp {

	private Long id; // 定时任务id
	private Long version; // 版本号
	private Long templateId; // m模板id
	private String templateName; // 模板名称
	private String templateClsName; // 模板类名
	private Long billId; // 单据id
	private String cron;// 执行时间
	private Integer enabled; // 是否启用
	private String params; // 执行参数

	/*public QuartzExecuteResp(QuartzJob job) {
		this.id = job.getId();
		this.version = job.getVersion();
		this.templateId = job.getTemplateId();
		this.templateName = job.getStr("templateName");
		this.templateClsName = job.getStr("templateClsName");
		this.billId = job.getBillId();
		this.cron = job.getCron();
		this.enabled = job.getEnabled().getId();
		this.params = job.getParams();
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

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

	public String getTemplateClsName() {
		return templateClsName;
	}

	public void setTemplateClsName(String templateClsName) {
		this.templateClsName = templateClsName;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
