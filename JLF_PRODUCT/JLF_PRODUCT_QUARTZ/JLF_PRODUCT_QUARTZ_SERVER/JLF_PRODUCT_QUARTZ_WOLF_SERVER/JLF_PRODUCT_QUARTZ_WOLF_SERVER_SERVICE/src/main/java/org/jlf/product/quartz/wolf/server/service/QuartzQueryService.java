package org.jlf.product.quartz.wolf.server.service;

import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.wolf.server.dao.QuartzExecuteLogDao;
import org.jlf.product.quartz.wolf.server.dao.QuartzJobDao;
import org.jlf.product.quartz.wolf.server.dao.QuartzTemplateDao;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.soa.mvc.metadata.ann.JLFMVCTrans;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;

/**
 * 
 * @ClassName: QuartzQueryService
 * @Description:QuartzQueryService
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCService
public class QuartzQueryService {

	private QuartzTemplateDao templateDao;
	private QuartzJobDao jobDao;
	private QuartzExecuteLogDao logDao;

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:��ȡjob��ϸ
	 * @param id
	 * @return
	 */
	@JLFMVCTrans
	public QuartzJob getJobDetail(Long id) {
		return jobDao.getJobDetail(id);
	}

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:��ҳ��ѯjob
	 * @param req
	 * @return
	 */
	@JLFMVCTrans
	public JLFMVCPage<QuartzJob> getJobPage(QuartzJobPageReq req) {
		return jobDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯjob�б�
	 * @param req
	 * @return
	 */
	@JLFMVCTrans
	public List<QuartzJob> getJobList(QuartzJobListReq req) {
		return jobDao.getList(req);
	}

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:��ȡtemplate��ϸ
	 * @param id
	 * @return
	 */
	@JLFMVCTrans
	public QuartzTemplate getTemplateDetail(Long id) {
		return templateDao.getById(id);
	}

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:��ҳ��ѯtemplate
	 * @param req
	 * @return
	 */
	@JLFMVCTrans
	public JLFMVCPage<QuartzTemplate> getTemplatePage(QuartzTemplatePageReq req) {
		return templateDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getTemplateList
	 * @Description:��ѯtemplateList
	 * @param req
	 * @return @
	 */
	@JLFMVCTrans
	public List<QuartzTemplate> getTemplateList(QuartzTemplateListReq req) {
		return templateDao.getList(req);
	}

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:��ȡlog��ϸ
	 * @param id
	 * @return
	 */
	@JLFMVCTrans
	public QuartzExecuteLog getLogDetail(Long id) {
		return logDao.getById(id);
	}

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:��ҳ��ѯ��־
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMVCTrans
	public JLFMVCPage<QuartzExecuteLog> getLogPage(QuartzExecuteLogPageReq req) {
		return logDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getReadyJobList
	 * @Description:���ݾ���״̬��ѯ��ʱ�����б�
	 * @return
	 */
	@JLFMVCTrans
	public List<QuartzJob> getReadyJobList(BooleanType ready) {
		return jobDao.getReadyList(ready);
	}
}
