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
 * @date 2019年7月5日
 */
@JLFMVCService
public class QuartzQueryService {

	private QuartzTemplateDao templateDao;
	private QuartzJobDao jobDao;
	private QuartzExecuteLogDao logDao;

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:获取job明细
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
	 * @Description:分页查询job
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
	 * @Description:查询job列表
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
	 * @Description:获取template明细
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
	 * @Description:分页查询template
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
	 * @Description:查询templateList
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
	 * @Description:获取log明细
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
	 * @Description:分页查询日志
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
	 * @Description:根据就绪状态查询定时任务列表
	 * @return
	 */
	@JLFMVCTrans
	public List<QuartzJob> getReadyJobList(BooleanType ready) {
		return jobDao.getReadyList(ready);
	}
}
