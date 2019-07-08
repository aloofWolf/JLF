package org.jlf.product.quartz.wolf.server.action;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.product.quartz.web.api.JLFQuartzDefineAction;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobUpdateReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateUpdateReq;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.product.quartz.wolf.server.service.QuartzDefineService;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
    * @ClassName: QuartzDefineAction
    * @Description:QuartzDefineAction
    * @author Lone Wolf
    * @date 2019Äê7ÔÂ6ÈÕ
 */
public class QuartzDefineAction implements JLFQuartzDefineAction{
	
	private QuartzDefineService service;

	@Override
	public void saveJob(QuartzJobSaveReq req) {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(req.getTemplateId());
		job.setBillId(req.getBillId());
		job.setCron(req.getCore());
		job.setEnabled(req.getEnabled());
		if (req.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
		}
		if (req.getParams() != null) {
			String params = JLFJsonClient.get().mapToJsonStr(req.getParams());
			job.setParams(params);
		}
		service.saveJob(job);
		
	}

	@Override
	public void updateJob(QuartzJobUpdateReq req) {
		QuartzJob job = new QuartzJob();
		job.setId(req.getId());
		job.setVersion(req.getVersion());
		job.setTemplateId(req.getTemplateId());
		job.setCron(req.getCore());
		job.setEnabled(req.getEnabled());
		if (req.getParams() != null) {
			String params = JLFJsonClient.get().mapToJsonStr(req.getParams());
			job.setParams(params);
		}
		service.updateJob(job);
		
	}

	@Override
	public void deleteJob(JLFMVCIdAndVersionRequest req) {
		service.deleteJob(req.getId(), req.getVersion());
		
	}

	@Override
	public void enabledJob(JLFMVCIdAndVersionRequest req) {
		service.enabledJob(req.getId(), req.getVersion());
		
	}

	@Override
	public void disabledJob(JLFMVCIdAndVersionRequest req) {
		service.disabledJob(req.getId(), req.getVersion());
		
	}

	@Override
	public void saveTemplate(QuartzTemplateSaveReq req) {
		QuartzTemplate template = new QuartzTemplate();
		template.setTemplateName(req.getTemplateName());
		template.setClsName(req.getClsName());
		template.setEnabled(req.getEnabled());
		service.saveTemplate(template);
		
	}

	@Override
	public void updateTemplate(QuartzTemplateUpdateReq req) {
		QuartzTemplate template = new QuartzTemplate();
		template.setId(req.getId());
		template.setVersion(req.getVersion());
		template.setTemplateName(req.getTemplateName());
		template.setClsName(req.getClsName());
		template.setEnabled(req.getEnabled());
		service.updateTemplate(template);
		
	}

	@Override
	public void deleteTemplate(JLFMVCIdAndVersionRequest req) {
		service.deleteTemplate(req.getId(), req.getVersion());
		
	}

	@Override
	public void enabledTemplate(JLFMVCIdAndVersionRequest req) {
		service.enabledTemplate(req.getId(), req.getVersion());
		
	}

	@Override
	public void disabledTemplate(JLFMVCIdAndVersionRequest req) {
		service.disabledTemplate(req.getId(), req.getVersion());
		
	}

}
