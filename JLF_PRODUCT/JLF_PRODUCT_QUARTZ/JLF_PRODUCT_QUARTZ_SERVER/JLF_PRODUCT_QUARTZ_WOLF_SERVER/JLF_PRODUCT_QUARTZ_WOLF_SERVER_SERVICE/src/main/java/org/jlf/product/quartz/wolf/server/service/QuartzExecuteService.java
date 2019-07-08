package org.jlf.product.quartz.wolf.server.service;

import org.jlf.product.quartz.wolf.server.dao.QuartzJobDao;
import org.jlf.soa.mvc.metadata.ann.JLFMVCTrans;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;

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

	/**
	 * 
	 * @Title: updateAllReady
	 * @Description:将所有的job改为就绪状态 @
	 */
	@JLFMVCTrans
	public void updateAllReady() {
		jobDao.updateAllReady();
	}

}
