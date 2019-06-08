package org.jlf.product.quartz.wolf.server.action;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.JLFQuartzJobAction;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobUpdateReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteResp;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.service.QuartzJobService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.route.JLFMVCRouteCls;

/**
 * 
 * @ClassName: QuartzExecuteWeb
 * @Description:QuartzExecuteWeb
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCRouteCls(type = 2)
public class QuartzExecuteAction implements JLFQuartzJobAction {

	private QuartzJobService service;

	@Override
	public void save(QuartzJobSaveReq req) throws Exception {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(req.getTemplateId());
		job.setBillId(req.getBillId());
		job.setCron(req.getCore());
		job.setEnabled(req.getEnabled());
		if (req.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
		}
		if (req.getParams() != null) {
			job.setParams(req.getParams().toJSONString());
		}
		service.save(job);

	}

	/**
	 * 
	 * @Title: update
	 * @Description:更新定时任务
	 * @param req
	 * @throws Exception
	 */
	public void update(QuartzJobUpdateReq req) throws Exception {
		QuartzJob job = new QuartzJob();
		job.setId(req.getHeader().getId());
		job.setVersion(req.getHeader().getVersion());
		job.setTemplateId(req.getTemplateId());
		job.setCron(req.getCore());
		job.setEnabled(req.getEnabled());
		if (req.getParams() != null) {
			job.setParams(req.getParams().toJSONString());
		}
		service.update(job);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除定时任务
	 * @param req
	 * @throws Exception
	 */
	public void delete(JLFMVCIdAndVersionRequest req) throws Exception {
		service.delete(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: enabled
	 * @Description:启用定时任务
	 * @param req
	 * @throws Exception
	 */
	public void enabled(JLFMVCIdAndVersionRequest req) throws Exception {
		service.enabled(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: disabled
	 * @Description:禁用定时任务
	 * @param req
	 * @throws Exception
	 */
	public void disabled(JLFMVCIdAndVersionRequest req) throws Exception {
		service.disabled(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: getDeatil
	 * @Description:获取定时任务明细
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@Override
	public QuartzExecuteResp getDeatil(JLFMVCIdRequest req) throws Exception {
		QuartzJob job = service.getById(req.getId());
		if (job == null) {
			throw new Exception("未获取到定时任务");
		}
		QuartzExecuteResp resp = new QuartzExecuteResp();
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

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询定时任务
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzJobPageReq req) throws Exception {
		JLFMVCPage<QuartzJob> page = service.getPage(req);
		List<QuartzJob> list = page.getDetails();
		List<QuartzExecuteResp> respList = new ArrayList<QuartzExecuteResp>();
		if (list != null) {
			for (QuartzJob job : list) {
				QuartzExecuteResp resp = new QuartzExecuteResp();
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
		return new JLFMVCPagingResponse(page.getTotalNum(), page.getTotalPage(), respList);
	}

	/**
	 * 
	 * @Title: getList
	 * @Description:查询定时任务列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public List<QuartzExecuteResp> getList(QuartzJobListReq req) throws Exception {
		List<QuartzJob> list = service.getList(req);
		List<QuartzExecuteResp> respList = new ArrayList<QuartzExecuteResp>();
		if (list != null) {
			for (QuartzJob job : list) {
				QuartzExecuteResp resp = new QuartzExecuteResp();
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
	
	public static void main(String[] args){
		System.out.println(QuartzExecuteAction.class.getInterfaces()[0].getName());
	}

}
