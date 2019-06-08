package org.jlf.product.quartz.wolf.server.service;

import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.wolf.server.dao.QuartzTemplateDao;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.service.JLFMAVCConnection;
import org.jlf.soa.mvc.service.JLFMVCService;
import org.jlf.soa.mvc.service.JLFMVCTrans;

public class QuartzTemplateService extends JLFMVCService<QuartzTemplate, QuartzTemplateDao> {

	private QuartzJobService quartzExecuteService;

	/**
	 * 
	 * @Title: save
	 * @Description:����ģ��
	 * @param template
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public QuartzTemplate save(QuartzTemplate template) throws Exception {
		QuartzTemplate oldTemplate = dao.getByTemplateName(template.getTemplateName());
		if (oldTemplate != null) {
			throw new Exception("ģ�������ظ�");
		}
		return super.save(template);

	}

	/**
	 * 
	 * @Title: delete
	 * @Description:����ģ��
	 * @param template
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void update(QuartzTemplate template) throws Exception {
		QuartzTemplate oldTemplate = dao.getByTemplateName(template.getTemplateName());
		if (oldTemplate != null && oldTemplate.getId().equals(template.getId())) {
			throw new Exception("ģ�������ظ�");
		}
		this.update(oldTemplate);
		quartzExecuteService.reStartByTemplateId(template.getId());
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��ģ��
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void delete(Long id, Long version) throws Exception {
		QuartzTemplate template = getByIdAndVersion(id, version);
		if (template == null) {
			throw new Exception("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
		newQuartzTemplate.setIsDelete(BooleanType.TRUE);
		newQuartzTemplate.setDeleteNum(id);
		dao.update(newQuartzTemplate);
		quartzExecuteService.disabledByTemplateId(id);
	}

	/**
	 * 
	 * @Title: enabled
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void enabled(Long id, Long version) throws Exception {
		QuartzTemplate template = getByIdAndVersion(id, version);
		if (template == null) {
			throw new Exception("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
		newQuartzTemplate.setEnabled(BooleanType.TRUE);
		dao.update(newQuartzTemplate);
	}

	/**
	 * 
	 * @Title: disabled
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void disabled(Long id, Long version) throws Exception {
		QuartzTemplate template = getByIdAndVersion(id, version);
		if (template == null) {
			throw new Exception("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
		newQuartzTemplate.setEnabled(BooleanType.FALSE);
		dao.update(newQuartzTemplate);
		quartzExecuteService.disabledByTemplateId(id);
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ҳ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public JLFMVCPage<QuartzTemplate> getPage(QuartzTemplatePageReq req) throws Exception {
		return dao.getPage(req);
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ҳ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public List<QuartzTemplate> getList(QuartzTemplateListReq req) throws Exception {
		return dao.getList(req);
	}
}
