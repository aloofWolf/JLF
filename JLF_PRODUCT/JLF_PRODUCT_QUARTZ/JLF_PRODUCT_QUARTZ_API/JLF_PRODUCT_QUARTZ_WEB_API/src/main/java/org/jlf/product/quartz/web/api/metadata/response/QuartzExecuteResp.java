package org.jlf.product.quartz.web.api.metadata.response;

/**
 * 
 * @ClassName: QuartzExecuteResp
 * @Description:��ʱ������б�������Ӧ����
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzExecuteResp {

	private Long id; // ��ʱ����id
	private Long version; // �汾��
	private Long templateId; // mģ��id
	private String templateName; // ģ������
	private String templateClsName; // ģ������
	private Long billId; // ����id
	private String cron;// ִ��ʱ��
	private Integer enabled; // �Ƿ�����
	private String params; // ִ�в���

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
