package org.jlf.product.quartz.wolf.server.core;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.service.QuartzJobService;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;

public class QuartzCore implements JLFQuartz {

	private QuartzJobService jobService = JLFMVCServiceStruc.getService(QuartzJobService.class);

	@Override
	public void saveJob(Long templateId, Long billId, String cron, BooleanType enabled, JLFJson params)
			throws Exception {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(templateId);
		job.setBillId(billId);
		job.setCron(cron);
		job.setEnabled(enabled);
		if (params != null) {
			job.setParams(params.toStr());
		}
		jobService.save(job);

	}

	@Override
	public void updateJob(Long id, Long version, Long templateId, Long billId, String cron, BooleanType enabled,
			JLFJson params) throws Exception {
		QuartzJob job = new QuartzJob();
		job.setId(id);
		job.setVersion(version);
		job.setTemplateId(templateId);
		job.setBillId(billId);
		job.setCron(cron);
		job.setEnabled(enabled);
		if (params != null) {
			job.setParams(params.toStr());
		}
		jobService.update(job);

	}

	@Override
	public void deleteJob(Long id, Long version) throws Exception {
		jobService.delete(id, version);

	}

	@Override
	public void enableJob(Long id, Long version) throws Exception {
		jobService.enabled(id, version);

	}

	@Override
	public void disableJob(Long id, Long version) throws Exception {
		jobService.disabled(id, version);

	}

}
