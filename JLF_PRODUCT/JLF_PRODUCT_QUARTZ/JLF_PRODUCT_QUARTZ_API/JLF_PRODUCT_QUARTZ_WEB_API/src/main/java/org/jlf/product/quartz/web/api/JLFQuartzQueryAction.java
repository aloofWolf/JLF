package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogPageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzJobPageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzJobResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplatePageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplateResp;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;

/**
 * 
 * @ClassName: JLFQuartzQueryAction
 * @Description:JLFQuartzQueryActionApi
 * @author Lone Wolf
 * @date 2019年7月5日
 */
@JLFMVCRouteCls(name="quartzQuery")
public interface JLFQuartzQueryAction {

	/**
	 * 
	 * @Title: getJobDeatil
	 * @Description:获取定时任务明细
	 * @param req
	 * @return
	 */
	public QuartzJobResp getJobDeatil(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:分页查询定时任务
	 * @param req
	 * @return
	 */
	public QuartzJobPageResp getJobPage(QuartzJobPageReq req);

	/**
	 * 
	 * @Title: getJobList
	 * @Description:查询定时任务列表
	 * @param req
	 * @return
	 */
	public List<QuartzJobResp> getJobList(QuartzJobListReq req);

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:获取模板详细信息
	 * @param req
	 * @return
	 */
	public QuartzTemplateResp getTemplateDetail(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:分页查询模板信息
	 * @param req
	 * @return
	 */
	public QuartzTemplatePageResp getTemplatePage(QuartzTemplatePageReq req);

	/**
	 * 
	 * @Title: getTemplateList
	 * @Description:查询模板信息列表
	 * @param req
	 * @return
	 */
	public List<QuartzTemplateResp> getTemplateList(QuartzTemplateListReq req);

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:获取定时任务执行日志明细信息
	 * @param req
	 * @return
	 */
	public QuartzExecuteLogResp getLogDetail(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:分页查询定时任务执行日志
	 * @param req
	 * @return
	 */
	public QuartzExecuteLogPageResp getLogPage(QuartzExecuteLogPageReq req);

}
