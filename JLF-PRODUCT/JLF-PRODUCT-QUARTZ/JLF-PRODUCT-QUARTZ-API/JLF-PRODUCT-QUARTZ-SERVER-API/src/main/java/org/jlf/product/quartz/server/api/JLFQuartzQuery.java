package org.jlf.product.quartz.server.api;

import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzTemplatePageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFQuartzQuery
 * @Description:JLFQuartzQuery
 * @author Lone Wolf
 * @date 2019年9月24日
 */
public interface JLFQuartzQuery {

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:获取定时任务明细
	 * @param req
	 * @return
	 */
	public JLFQuartzJobEntity getJobDetail(Long id);

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:分页查询定时任务
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzJobEntity> getJobPage(JLFQuartzJobPageReq req);

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:获取模板详细信息
	 * @param req
	 * @return
	 */
	public JLFQuartzTemplateEntity getTemplateDetail(Long id);

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:分页查询模板信息
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzTemplateEntity> getTemplatePage(JLFQuartzTemplatePageReq req);

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:获取定时任务执行日志明细信息
	 * @param req
	 * @return
	 */
	public JLFQuartzExecuteLogEntity getLogDetail(Long id);

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:分页查询定时任务执行日志
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzExecuteLogEntity> getLogPage(JLFQuartzExecuteLogPageReq req);

}
