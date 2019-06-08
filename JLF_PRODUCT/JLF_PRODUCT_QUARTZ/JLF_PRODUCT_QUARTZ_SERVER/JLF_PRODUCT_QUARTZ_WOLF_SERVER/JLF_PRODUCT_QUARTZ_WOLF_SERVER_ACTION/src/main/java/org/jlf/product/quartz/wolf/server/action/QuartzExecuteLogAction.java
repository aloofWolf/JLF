package org.jlf.product.quartz.wolf.server.action;

import java.util.ArrayList;
import java.util.List;

import org.jlf.product.quartz.web.api.JLFQuartzExecuteLogAction;
import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogResp;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.product.quartz.wolf.server.service.QuartzExecuteLogService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.route.JLFMVCRouteCls;

/**
 * 
 * @ClassName: QuartzExecuteLogWeb
 * @Description:QuartzExecuteLogWeb
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCRouteCls(type = 2)
public class QuartzExecuteLogAction implements JLFQuartzExecuteLogAction{

	private QuartzExecuteLogService service;

	/**
	 * 
	 * @Title: getDetail
	 * @Description:获取定时任务执行日志明细信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzExecuteLogResp getDetail(JLFMVCIdRequest req) throws Exception {
		QuartzExecuteLog quartzExecuteLog = service.getById(req.getId());
		if (quartzExecuteLog == null) {
			throw new Exception("未获取到执行日志");
		}
		QuartzExecuteLogResp resp = new QuartzExecuteLogResp();
		resp.setTemplateId(quartzExecuteLog.getTemplateId());
		resp.setTemplateName(quartzExecuteLog.getTemplateName());
		resp.setTemplateClsName(quartzExecuteLog.getTemplateClsName());
		resp.setJobId(quartzExecuteLog.getJobId());
		resp.setBillId(quartzExecuteLog.getBillId());
		resp.setParams(quartzExecuteLog.getParams());
		resp.setStartTime(quartzExecuteLog.getStartTime());
		resp.setEndTime(quartzExecuteLog.getEndTime());
		resp.setExecuteResult(quartzExecuteLog.getExecuteResult().getId());
		resp.setFailReason(quartzExecuteLog.getFailReason());
		return resp;
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询定时任务执行日志
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzExecuteLogPageReq req) throws Exception {
		JLFMVCPage<QuartzExecuteLog> page = service.getPage(req);
		List<QuartzExecuteLog> list = page.getDetails();
		List<QuartzExecuteLogResp> respList = new ArrayList<QuartzExecuteLogResp>();
		if (list != null) {
			for (QuartzExecuteLog quartzExecuteLog : list) {
				QuartzExecuteLogResp resp = new QuartzExecuteLogResp();
				resp.setTemplateId(quartzExecuteLog.getTemplateId());
				resp.setTemplateName(quartzExecuteLog.getTemplateName());
				resp.setTemplateClsName(quartzExecuteLog.getTemplateClsName());
				resp.setJobId(quartzExecuteLog.getJobId());
				resp.setBillId(quartzExecuteLog.getBillId());
				resp.setParams(quartzExecuteLog.getParams());
				resp.setStartTime(quartzExecuteLog.getStartTime());
				resp.setEndTime(quartzExecuteLog.getEndTime());
				resp.setExecuteResult(quartzExecuteLog.getExecuteResult().getId());
				resp.setFailReason(quartzExecuteLog.getFailReason());
				respList.add(resp);
			}
		}
		return new JLFMVCPagingResponse(page.getTotalNum(), page.getTotalPage(), respList);

	}

}
