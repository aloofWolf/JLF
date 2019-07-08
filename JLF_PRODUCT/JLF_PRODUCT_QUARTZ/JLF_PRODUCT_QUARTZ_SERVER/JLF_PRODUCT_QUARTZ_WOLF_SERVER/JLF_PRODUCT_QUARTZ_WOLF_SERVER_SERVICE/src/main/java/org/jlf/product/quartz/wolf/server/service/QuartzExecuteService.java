package org.jlf.product.quartz.wolf.server.service;

import org.jlf.product.quartz.wolf.server.dao.QuartzJobDao;
import org.jlf.soa.mvc.metadata.ann.JLFMVCTrans;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;

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

	/**
	 * 
	 * @Title: updateAllReady
	 * @Description:�����е�job��Ϊ����״̬ @
	 */
	@JLFMVCTrans
	public void updateAllReady() {
		jobDao.updateAllReady();
	}

}
