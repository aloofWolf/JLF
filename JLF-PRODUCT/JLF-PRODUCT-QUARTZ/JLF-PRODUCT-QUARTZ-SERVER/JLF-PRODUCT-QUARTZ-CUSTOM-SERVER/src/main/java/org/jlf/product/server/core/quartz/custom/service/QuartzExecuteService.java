package org.jlf.product.server.core.quartz.custom.service;

import org.jlf.product.server.core.quartz.custom.dao.QuartzJobDao;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: QuartzExecuteService
 * @Description:QuartzExecuteService
 * @author Lone Wolf
 * @date 2019年7月5日
 */
@JLFMVCService
public class QuartzExecuteService {

	private QuartzJobDao jobDao;

	/**
	 * 
	 * @Title: reStartByTemplateId
	 * @Description:重启一个模板下所有已启动的任务
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
	 * @Description:禁用一个模板下所有已启动的任务
	 * @param templateId
	 * @
	 */
	@JLFMVCTrans
	public void disabledByTemplateId(Long templateId) {
		jobDao.disabledByTemplateId(templateId);
	}
}
