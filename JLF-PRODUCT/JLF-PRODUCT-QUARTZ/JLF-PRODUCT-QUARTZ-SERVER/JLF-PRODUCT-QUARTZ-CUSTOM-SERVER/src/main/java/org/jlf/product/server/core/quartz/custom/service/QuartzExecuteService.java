package org.jlf.product.server.core.quartz.custom.service;

import org.jlf.product.server.core.quartz.custom.dao.QuartzJobDao;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: QuartzExecuteService
 * @Description:QuartzExecuteService
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCService
public class QuartzExecuteService {

	private QuartzJobDao jobDao;

	/**
	 * 
	 * @Title: reStartByTemplateId
	 * @Description:����һ��ģ��������������������
	 * @param templateId
	 * @
	 */
	@JLFMVCTrans
	public void reStartByTemplateId(Long templateId) {
		jobDao.reStartByTemplateId(templateId);
	}

	/**
	 * 
	 * @Title: disabledByTemplateId
	 * @Description:����һ��ģ��������������������
	 * @param templateId
	 * @
	 */
	@JLFMVCTrans
	public void disabledByTemplateId(Long templateId) {
		jobDao.disabledByTemplateId(templateId);
	}
}
