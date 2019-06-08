package org.jlf.product.quartz.web.api.metadata.response;

/**
 * 
 * @ClassName: QuartzTemplateResp
 * @Description:定时任务模板的列表详情响应参数
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzTemplateResp {

	private Long id; // 模板id
	private Long version; // 版本号
	private String templateName; // 模板名称
	private String clsName; // 模板类名
	private Integer enabled; // 是否启用

	/*public QuartzTemplateResp(QuartzTemplate template) {
		this.id = template.getId();
		this.version = template.getVersion();
		this.templateName = template.getTemplateName();
		this.clsName = template.getClsName();
		this.enabled = template.getEnabled().getId();
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

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
