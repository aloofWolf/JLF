package org.jlf.product.quartz.web.api.metadata.response;

/**
 * 
 * @ClassName: QuartzTemplateResp
 * @Description:��ʱ����ģ����б�������Ӧ����
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzTemplateResp {

	private Long id; // ģ��id
	private Long version; // �汾��
	private String templateName; // ģ������
	private String clsName; // ģ������
	private Integer enabled; // �Ƿ�����

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
