package org.jlf.product.server.core.quartz.custom.action;

import org.jlf.product.quartz.web.api.JLFQuartzQueryAction;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzTemplatePageReq;
import org.jlf.product.server.core.quartz.custom.service.QuartzQueryService;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzQueryAction
 * @Description:QuartzQueryAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
public class QuartzQueryAction implements JLFQuartzQueryAction {

	private QuartzQueryService service;

	@Override
	public JLFQuartzJobEntity getJobDeatil(Long id) {
		return service.getJobDetail(id);
	}

	@Override
	public JLFMVCPagingResponse<JLFQuartzJobEntity> getJobPage(JLFQuartzJobPageReq req) {
		return service.getJobPage(req);
	}

	@Override
	public JLFQuartzTemplateEntity getTemplateDetail(Long id) {
		return service.getTemplateDetail(id);
	}

	@Override
	public JLFMVCPagingResponse<JLFQuartzTemplateEntity> getTemplatePage(JLFQuartzTemplatePageReq req) {
		return service.getTemplatePage(req);
	}

	@Override
	public JLFQuartzExecuteLogEntity getLogDetail(Long id) {
		return service.getLogDetail(id);
	}

	@Override
	public JLFMVCPagingResponse<JLFQuartzExecuteLogEntity> getLogPage(JLFQuartzExecuteLogPageReq req) {
		return service.getLogPage(req);
	}

}
