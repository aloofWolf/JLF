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
 * @date 2019��7��5��
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
	 * @Description:���涨ʱ����
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
	 * @Description:����һ�鶨ʱ����
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void saveJobs(String groupName, List<JLFQuartzJobEntity> jobs) {
		// ���groupName�Ƿ����
		if (groupNameExist(groupName)) {
			throw new JLFException("groupName�Ѵ���:" + groupName);
		}
		if (jobs != null) {
			JLFQuartzTemplateEntity template = null;
			for (JLFQuartzJobEntity job : jobs) {
				job.setGroupName(groupName);
				template = templateDao.getById(job.getTemplateId());
				if (template == null) {
					throw new JLFException("ģ�岻����:" + job.getTemplateId());
				}
				if (template.getEnabled().equals(BooleanType.FALSE)) {
					throw new JLFException("ģ���ѱ�����:" + job.getTemplateId());
				}
				
				//���������houstIpΪ��,��ȡ��ǰ��������ip
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
	 * @Description:��һ��group����ӵ�����ʱ����
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
	 * @Description:��һ��group�����һ�鶨ʱ����
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void addJobs(String groupName, List<JLFQuartzJobEntity> jobs){
		// ���groupName�Ƿ����
		if (!groupNameExist(groupName)) {
			throw new JLFException("groupName������:" + groupName);
		}
		if (jobs != null) {
			JLFQuartzTemplateEntity template = null;
			for (JLFQuartzJobEntity job : jobs) {
				job.setGroupName(groupName);
				template = templateDao.getById(job.getTemplateId());
				if (template == null) {
					throw new JLFException("ģ�岻����:" + job.getTemplateId());
				}
				if (template.getEnabled().equals(BooleanType.FALSE)) {
					throw new JLFException("ģ���ѱ�����:" + job.getTemplateId());
				}

				//���������houstIpΪ��,��ȡ��ǰ��������ip
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
	 * @Description:���¶�ʱ����
	 * @param job
	 */
	@JLFMVCTrans
	@Override
	public void updateJob(JLFQuartzJobEntity job) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(job.getId(), job.getVersion());
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		Long templateId = job.getTemplateId();
		if (templateId != null) {
			JLFQuartzTemplateEntity template = templateDao.getById(job.getTemplateId());
			if (template == null) {
				throw new JLFException("ģ�岻����");
			}
			if (template.getEnabled().equals(BooleanType.TRUE)) {
				throw new JLFException("ģ���ѱ�����");
			}
		}
		jobDao.update(job);
	}

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:ɾ����ʱ����
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void deleteJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		jobDao.delete(id, version);
	}
	
	/**
	 * 
	 * @Title: deleteJobs
	 * @Description:ɾ��һ�鶨ʱ����
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
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void enabledJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
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
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void disabledJob(Long id, Long version) {
		JLFQuartzJobEntity oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
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
	 * @Description:����ģ��
	 * @param template
	 */
	@JLFMVCTrans
	@Override
	public void saveTemplate(JLFQuartzTemplateEntity template) {
		JLFQuartzTemplateEntity oldTemplate = templateDao.getByTemplateName(template.getTemplateName());
		if (oldTemplate != null) {
			throw new JLFException("ģ�������ظ�");
		}
		templateDao.save(template);

	}

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:����ģ��
	 * @param template
	 */
	@JLFMVCTrans
	@Override
	public void updateTemplate(JLFQuartzTemplateEntity template) {
		JLFQuartzTemplateEntity oldTemplate = templateDao.getByTemplateName(template.getTemplateName());
		if (oldTemplate == null) {
			throw new JLFException("ģ�岻����");
		}
		oldTemplate = templateDao.getByTemplateNameWithOutId(template.getTemplateName(), template.getId());
		if (oldTemplate != null) {
			throw new JLFException("ģ�������ظ�");
		}
		templateDao.update(oldTemplate);
		executeService.reStartByTemplateId(template.getId());
	}

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:ɾ��ģ��
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void deleteTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
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
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void enabledTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		JLFQuartzTemplateEntity newQuartzTemplate = new JLFQuartzTemplateEntity();
		newQuartzTemplate.setEnabled(BooleanType.TRUE);
		templateDao.update(newQuartzTemplate);
	}

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans
	@Override
	public void disabledTemplate(Long id, Long version) {
		JLFQuartzTemplateEntity template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		JLFQuartzTemplateEntity newQuartzTemplate = new JLFQuartzTemplateEntity();
		newQuartzTemplate.setEnabled(BooleanType.FALSE);
		templateDao.update(newQuartzTemplate);
		executeService.disabledByTemplateId(id);
	}

	/**
	 * 
	 * @Title: saveLog
	 * @Description:������־
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
			throw new JLFException("��ʱ���񲻴���");
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
	 * @Description: ���groupName�Ƿ����
	 * @param groupName
	 * @return
	 */
	private boolean groupNameExist(String groupName) {
		// 1.������ݿ����Ƿ����ظ���groupName
		List<JLFQuartzJobEntity> jobs = jobDao.getListByGroupName(groupName);

		if (jobs.size() > 1) {
			return true;
		}

		// 2.����ڻ�����,�Ƿ����ظ���groupName,��ֹ�ڲ��������,���ݿ���ʧЧ
		boolean flg = JLFCacheClient.get().setnx(groupName, groupNameValue);
		if (!flg) {
			return true;
		}

		return false;
	}

	

}
