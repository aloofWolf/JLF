package org.jlf.product.server.core.quartz.custom.service;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.util.HostUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.cache.JLFCacheClient;
import org.jlf.product.quartz.server.api.JLFQuartzDefine;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.server.core.quartz.custom.dao.QuartzExecuteLogDao;
import org.jlf.product.server.core.quartz.custom.dao.QuartzJobDao;
import org.jlf.product.server.core.quartz.custom.dao.QuartzTemplateDao;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: QuartzDefineService
 * @Description:QuartzDefineService
 * @author Lone Wolf
 * @date 2019年7月5日
 */
@JLFMVCService
public class QuartzDefineService implements JLFQuartzDefine {

	private QuartzExecuteService executeService;

	private QuartzTemplateDao templateDao;
	private QuartzJobDao jobDao;
	private QuartzExecuteLogDao logDao;

	private static final String groupNameValue = "groupName";

	/**
	 * 
	 * @Title: saveJob
	 * @Description:保存定时任务
	 * @param list
	 */
	@JLFMVCTrans
	@Override
	public void saveJob(JLFQuartzJobEntity job) {
		
		List<JLFQuartzJobEntity> jobs = new ArrayList<JLFQuartzJobEntity>();
        jobs.add(job);
        saveJobs(job.getGroupName(),jobs);
	}

	/**
	 * 
	 * @Title: saveJobs
	 * @Description:保存一组定时任务
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void saveJobs(String groupName, List<JLFQuartzJobEntity> jobs) {
		// 检查groupName是否存在
		if (groupNameExist(groupName)) {
			throw new JLFException("groupName已存在:" + groupName);
		}
		if (jobs != null) {
			JLFQuartzTemplateEntity template = null;
			for (JLFQuartzJobEntity job : jobs) {
				job.setGroupName(groupName);
				template = templateDao.getById(job.getTemplateId());
				if (template == null) {
					throw new JLFException("模板不存在:" + job.getTemplateId());
				}
				if (template.getEnabled().equals(BooleanType.FALSE)) {
					throw new JLFException("模板已被禁用:" + job.getTemplateId());
				}
				
				//如果传来的houstIp为空,则取当前服务器的ip
				if(job.getHostIp() == null || job.getHostIp().length() == 0){
					job.setHostIp(HostUtil.getCurrHostIp());
				}

				jobDao.save(job);
			}

		}
	}
	
	/**
	 * 
	 * @Title: addJob
	 * @Description:向一个group中添加单个定时任务
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void addJob(String groupName,JLFQuartzJobEntity job){
		List<JLFQuartzJobEntity> jobs = new ArrayList<JLFQuartzJobEntity>();
        jobs.add(job);
        saveJobs(groupName,jobs);
	}

	/**
	 * 
	 * @Title: addJobs
	 * @Description:向一个group中添加一组定时任务
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void addJobs(String groupName, List<JLFQuartzJobEntity> jobs){
		// 检查groupName是否存在
		if (!groupNameExist(groupName)) {
			throw new JLFException("groupName不存在:" + groupName);
		}
		if (jobs != null) {
			JLFQuartzTemplateEntity template = null;
			for (JLFQuartzJobEntity job : jobs) {
				job.setGroupName(groupName);
				template = templateDao.getById(job.getTemplateId());
				if (template == null) {
					throw new JLFException("模板不存在:" + job.getTemplateId());
				}
				if (template.getEnabled().equals(BooleanType.FALSE)) {
					throw new JLFException("模板已被禁用:" + job.getTemplateId());
				}

				//如果传来的houstIp为空,则取当前服务器的ip
				if(job.getHostIp() == null || job.getHostIp().length() == 0){
					job.setHostIp(HostUtil.getCurrHostIp());
				}
				jobDao.save(job);
			}

		}
	}

	/**
	 * 
	 * @Title: updateJob
	 * @Description:更新定时任务
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void updateJob(JLFQuartzJobEntity job) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(job.getId(), job.getVersion());
		if (oldJob == null) {
			throw new JLFException("定时任务不存在");
		}
		Long templateId = job.getTemplateId();
		if (templateId != null) {
			JLFQuartzTemplateEntity template = templateDao.getById(job.getTemplateId());
			if (template == null) {
				throw new JLFException("模板不存在");
			}
			if (template.getEnabled().equals(BooleanType.TRUE)) {
				throw new JLFException("模板已被禁用");
			}
		}
		jobDao.update(job);
	}

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:删除定时任务
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void deleteJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("定时任务不存在");
		}
		jobDao.delete(id, version);
	}
	
	/**
	 * 
	 * @Title: deleteJobs
	 * @Description:删除一组定时任务
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void deleteJobs(String groupName){
		jobDao.deleteByGroup(groupName);
	}

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:启用定时任务
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void enabledJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("定时任务不存在");
		}
		if (oldJob.getEnabled().equals(BooleanType.TRUE)) {
			return;
		}
		JLFQuartzJobEntity newJob = new JLFQuartzJobEntity();
		newJob.setId(id);
		newJob.setVersion(version);
		newJob.setEnabled(BooleanType.TRUE);
		jobDao.update(newJob);
	}
	
	@JLFMVCTrans
	@Override
	public void enabledJobs(String groupName){
		jobDao.updateEnableByGroup(groupName, BooleanType.TRUE, BooleanType.FALSE);
	}

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:禁用定时任务
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void disabledJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("定时任务不存在");
		}
		if (oldJob.getEnabled().equals(BooleanType.FALSE)) {
			return;
		}
		JLFQuartzJobEntity newJob = new JLFQuartzJobEntity();
		newJob.setId(id);
		newJob.setVersion(version);
		newJob.setEnabled(BooleanType.FALSE);
		jobDao.update(newJob);
	}
	
	public void disabledJobs(String groupName){
		jobDao.updateEnableByGroup(groupName, BooleanType.FALSE, BooleanType.TRUE);
	}

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:保存模板
	 * @param template
	 */
	@JLFMVCTrans
	@Override
	public void saveTemplate(JLFQuartzTemplateEntity template) {
		JLFQuartzTemplateEntity oldTemplate = templateDao.getByTemplateName(template.getTemplateName());
		if (oldTemplate != null) {
			throw new JLFException("模板名称重复");
		}
		templateDao.save(template);

	}

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:更新模板
	 * @param template
	 */
	@JLFMVCTrans
	@Override
	public void updateTemplate(JLFQuartzTemplateEntity template) {
		JLFQuartzTemplateEntity oldTemplate = templateDao.getByTemplateName(template.getTemplateName());
		if (oldTemplate == null) {
			throw new JLFException("模板不存在");
		}
		oldTemplate = templateDao.getByTemplateNameWithOutId(template.getTemplateName(), template.getId());
		if (oldTemplate != null) {
			throw new JLFException("模板名称重复");
		}
		templateDao.update(oldTemplate);
		executeService.reStartByTemplateId(template.getId());
	}

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:删除模板
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void deleteTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("模板不存在");
		}
		JLFQuartzTemplateEntity newQuartzTemplate = new JLFQuartzTemplateEntity();
		newQuartzTemplate.setIsDelete(BooleanType.TRUE);
		newQuartzTemplate.setDeleteNum(id);
		templateDao.update(newQuartzTemplate);
		executeService.disabledByTemplateId(id);
	}

	/**
	 * 
	 * @Title: enabledTemplate
	 * @Description:启用模板
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void enabledTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("模板不存在");
		}
		JLFQuartzTemplateEntity newQuartzTemplate = new JLFQuartzTemplateEntity();
		newQuartzTemplate.setEnabled(BooleanType.TRUE);
		templateDao.update(newQuartzTemplate);
	}

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:禁用模板
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void disabledTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("模板不存在");
		}
		JLFQuartzTemplateEntity newQuartzTemplate = new JLFQuartzTemplateEntity();
		newQuartzTemplate.setEnabled(BooleanType.FALSE);
		templateDao.update(newQuartzTemplate);
		executeService.disabledByTemplateId(id);
	}

	/**
	 * 
	 * @Title: saveLog
	 * @Description:保存日志
	 * @param log
	 */
	@JLFMVCTrans
	public void saveLog(JLFQuartzExecuteLogEntity log) {
		logDao.save(log);
	}

	@JLFMVCTrans
	@Override
	public void transferJob(Long id, Long version, String hostIp) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("定时任务不存在");
		}
		JLFQuartzJobEntity newJob = new JLFQuartzJobEntity();
		newJob.setId(id);
		newJob.setVersion(version);
		newJob.setHostIp(hostIp);
		jobDao.update(newJob);
		
	}

	@JLFMVCTrans
	@Override
	public void batchTransferJob(String oldHostIp, String newHostIp) {
		jobDao.updateHostIp(oldHostIp, newHostIp);
		
	}

	/**
	 * 
	 * @Title: groupNameExist
	 * @Description: 检查groupName是否存在
	 * @param groupName
	 * @return
	 */
	private boolean groupNameExist(String groupName) {
		// 1.检查数据库中是否有重复的groupName
		List<JLFQuartzJobEntity> jobs = jobDao.getListByGroupName(groupName);

		if (jobs.size() > 1) {
			return true;
		}

		// 2.检查在缓存中,是否有重复的groupName,防止在并发情况下,数据库检查失效
		boolean flg = JLFCacheClient.get().setnx(groupName, groupNameValue);
		if (!flg) {
			return true;
		}

		return false;
	}

	

}
