package org.jlf.product.quartz.wolf.server.action;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.exception.JLFException;
import org.jlf.product.quartz.web.api.JLFQuartzQueryAction;
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
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.product.quartz.wolf.server.service.QuartzQueryService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;

/**
 * 
 * @ClassName: QuartzQueryAction
 * @Description:QuartzQueryAction
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class QuartzQueryAction implements JLFQuartzQueryAction {

	private QuartzQueryService queryService;

	@Override
	public QuartzJobResp getJobDeatil(JLFMVCIdRequest req) {
		QuartzJob job = queryService.getJobDetail(req.getId());
		if (job == null) {
			throw new JLFException("未获取到定时任务");
		}
		QuartzJobResp resp = new QuartzJobResp();
		resp.setId(job.getId());
		resp.setVersion(job.getVersion());
		resp.setTemplateName(job.getStr("templateName"));
		resp.setTemplateClsName(job.getStr("templateClsName"));
		resp.setBillId(job.getBillId());
		resp.setCron(job.getCron());
		resp.setEnabled(job.getEnabled().getId());
		resp.setParams(job.getParams());
		return resp;
	}

	@Override
	public QuartzJobPageResp getJobPage(QuartzJobPageReq req) {
		JLFMVCPage<QuartzJob> page = queryService.getJobPage(req);
		List<QuartzJob> list = page.getDetails();
		List<QuartzJobResp> respList = new ArrayList<QuartzJobResp>();
		if (list != null) {
			for (QuartzJob job : list) {
				QuartzJobResp resp = new QuartzJobResp();
				resp.setId(job.getId());
				resp.setVersion(job.getVersion());
				resp.setTemplateName(job.getStr("templateName"));
				resp.setTemplateClsName(job.getStr("templateClsName"));
				resp.setBillId(job.getBillId());
				resp.setCron(job.getCron());
				resp.setEnabled(job.getEnabled().getId());
				resp.setParams(job.getParams());
				respList.add(resp);
			}
		}
		return new QuartzJobPageResp(page.getTotalNum(), page.getTotalPage(), respList);
	}

	@Override
	public List<QuartzJobResp> getJobList(QuartzJobListReq req) {
		List<QuartzJob> list = queryService.getJobList(req);
		List<QuartzJobResp> respList = new ArrayList<QuartzJobResp>();
		if (list != null) {
			for (QuartzJob job : list) {
				QuartzJobResp resp = new QuartzJobResp();
				resp.setId(job.getId());
				resp.setVersion(job.getVersion());
				resp.setTemplateName(job.getStr("templateName"));
				resp.setTemplateClsName(job.getStr("templateClsName"));
				resp.setBillId(job.getBillId());
				resp.setCron(job.getCron());
				resp.setEnabled(job.getEnabled().getId());
				resp.setParams(job.getParams());
				respList.add(resp);
			}
		}
		return respList;
	}

	@Override
	public QuartzTemplateResp getTemplateDetail(JLFMVCIdRequest req) {
		QuartzTemplate template = queryService.getTemplateDetail(req.getId());
		if (template == null) {
			throw new JLFException("未获取到定时任务模板");
		}
		QuartzTemplateResp resp = new QuartzTemplateResp();
		resp.setId(template.getId());
		resp.setVersion(template.getVersion());
		resp.setTemplateName(template.getTemplateName());
		resp.setClsName(template.getClsName());
		resp.setEnabled(template.getEnabled().getId());
		return resp;
	}

	@Override
	public QuartzTemplatePageResp getTemplatePage(QuartzTemplatePageReq req) {
		JLFMVCPage<QuartzTemplate> page = queryService.getTemplatePage(req);
		List<QuartzTemplate> list = page.getDetails();
		List<QuartzTemplateResp> respList = new ArrayList<QuartzTemplateResp>();
		if (list != null) {
			for (QuartzTemplate template : list) {
				QuartzTemplateResp resp = new QuartzTemplateResp();
				resp.setId(template.getId());
				resp.setVersion(template.getVersion());
				resp.setTemplateName(template.getTemplateName());
				resp.setClsName(template.getClsName());
				resp.setEnabled(template.getEnabled().getId());
				respList.add(resp);
			}
		}
		return new QuartzTemplatePageResp(page.getTotalNum(), page.getTotalPage(), respList);
	}

	@Override
	public List<QuartzTemplateResp> getTemplateList(QuartzTemplateListReq req) {
		List<QuartzTemplate> list = queryService.getTemplateList(req);
		List<QuartzTemplateResp> respList = new ArrayList<QuartzTemplateResp>();
		if (list != null) {
			for (QuartzTemplate template : list) {
				QuartzTemplateResp resp = new QuartzTemplateResp();
				resp.setId(template.getId());
				resp.setVersion(template.getVersion());
				resp.setTemplateName(template.getTemplateName());
				resp.setClsName(template.getClsName());
				resp.setEnabled(template.getEnabled().getId());
				respList.add(resp);
			}
		}
		return respList;
	}

	@Override
	public QuartzExecuteLogResp getLogDetail(JLFMVCIdRequest req) {
		QuartzExecuteLog quartzExecuteLog = queryService.getLogDetail(req.getId());
		if (quartzExecuteLog == null) {
			throw new JLFException("未获取到执行日志");
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

	@Override
	public QuartzExecuteLogPageResp getLogPage(QuartzExecuteLogPageReq req) {
		JLFMVCPage<QuartzExecuteLog> page = queryService.getLogPage(req);
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
		return new QuartzExecuteLogPageResp(page.getTotalNum(), page.getTotalPage(), respList);
	}

}
