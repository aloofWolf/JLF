package org.jlf.product.server.core.quartz.custom.action;

import java.util.List;

import org.jlf.product.quartz.web.api.JLFQuartzDefineAction;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.server.core.quartz.custom.service.QuartzDefineService;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: QuartzDefineAction
 * @Description:QuartzDefineAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */

@JLFMVCRoute(routeClsType = 2)
public class QuartzDefineAction implements JLFQuartzDefineAction {

	private QuartzDefineService service;

	@Override
	public void saveJob(JLFQuartzJobEntity job) {
		service.saveJob(job);

	}

	@Override
	public void saveJobs(String groupName, List<JLFQuartzJobEntity> jobs) {
		service.saveJobs(groupName, jobs);

	}

	@Override
	public void addJob(String groupName, JLFQuartzJobEntity job) {
		service.addJob(groupName, job);

	}

	@Override
	public void addJobs(String groupName, List<JLFQuartzJobEntity> jobs) {
		service.addJobs(groupName, jobs);

	}

	@Override
	public void updateJob(Long id, Long version, JLFQuartzJobEntity job) {
		job.setId(id);
		job.setVersion(version);
		service.updateJob(job);

	}

	@Override
	public void deleteJob(Long id, Long version) {
		service.deleteJob(id, version);

	}

	@Override
	public void deleteJobs(String groupName) {
		service.deleteJobs(groupName);

	}

	@Override
	public void enabledJob(Long id, Long version) {
		service.enabledJob(id, version);
	}

	@Override
	public void enabledJobs(String groupName) {
		service.enabledJobs(groupName);

	}

	@Override
	public void disabledJob(Long id, Long version) {
		service.disabledJob(id, version);

	}

	@Override
	public void disabledJobs(String groupName) {
		service.disabledJobs(groupName);

	}

	@Override
	public void saveTemplate(JLFQuartzTemplateEntity template) {
		service.saveTemplate(template);
	}

	@Override
	public void updateTemplate(Long id, Long version, JLFQuartzTemplateEntity template) {
		template.setId(id);
		template.setVersion(version);
		service.updateTemplate(template);

	}

	@Override
	public void deleteTemplate(Long id, Long version) {
		service.deleteTemplate(id, version);

	}

	@Override
	public void enabledTemplate(Long id, Long version) {
		service.enabledJob(id, version);

	}

	@Override
	public void disabledTemplate(Long id, Long version) {
		service.disabledJob(id, version);

	}

	@Override
	public void transferJob(Long id, Long version, String hostIp) {
		service.transferJob(id, version, hostIp);

	}

	@Override
	public void batchTransferJob(String oldHostIp, String newHostIp) {
		service.batchTransferJob(oldHostIp, newHostIp);

	}

}
