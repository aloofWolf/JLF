package org.jlf.product.quartz.wolf.server.service;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.wolf.server.dao.QuartzExecuteLogDao;
import org.jlf.product.quartz.wolf.server.dao.QuartzJobDao;
import org.jlf.product.quartz.wolf.server.dao.QuartzTemplateDao;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;
import org.jlf.soa.mvc.metadata.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: QuartzDefineService
 * @Description:QuartzDefineService
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCService
public class QuartzDefineService implements JLFQuartz {

	private QuartzExecuteService executeService;

	private QuartzTemplateDao templateDao;
	private QuartzJobDao jobDao;
	private QuartzExecuteLogDao logDao;

	/**
	 * 
	 * @Title: saveJob
	 * @Description:���涨ʱ����
	 * @param list
	 */
	@JLFMVCTrans(dbName="?")
	public QuartzJob saveJob(QuartzJob job) {
		QuartzTemplate template = templateDao.getById(job.getTemplateId());
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		if (template.getEnabled().equals(BooleanType.FALSE)) {
			throw new JLFException("ģ���ѱ�����");
		}
		if (job.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
		}
		return jobDao.save(job);
	}

	/**
	 * 
	 * @Title: updateJob
	 * @Description:���¶�ʱ����
	 * @param job
	 */
	@JLFMVCTrans(dbName="?")
	public void updateJob(QuartzJob job) {
		QuartzJob oldJob = jobDao.getByIdAndVersion(job.getId(), job.getVersion());
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		Long templateId = job.getTemplateId();
		if (templateId != null) {
			QuartzTemplate template = templateDao.getById(templateId);
			if (template == null) {
				throw new JLFException("ģ�岻����");
			}
			if (template.getEnabled().equals(BooleanType.TRUE)) {
				throw new JLFException("ģ���ѱ�����");
			}
		}
		if (job.getEnabled() != null && job.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
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
	@JLFMVCTrans(dbName="?")
	public void deleteJob(Long id, Long version) {
		QuartzJob oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setIsDelete(BooleanType.TRUE);
		newJob.setDeleteNum(id);
		if (oldJob.getEnabled().equals(BooleanType.TRUE)) {
			newJob.setEnabled(BooleanType.FALSE);
			newJob.setReady(BooleanType.TRUE);
		}
		jobDao.update(newJob);
	}

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans(dbName="?")
	public void enabledJob(Long id, Long version) {
		QuartzJob oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		if (oldJob.getEnabled().equals(BooleanType.TRUE)) {
			return;
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setEnabled(BooleanType.TRUE);
		newJob.setReady(BooleanType.TRUE);
		jobDao.update(newJob);
	}

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 */
	@JLFMVCTrans(dbName="?")
	public void disabledJob(Long id, Long version) {
		QuartzJob oldJob = jobDao.getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new JLFException("��ʱ���񲻴���");
		}
		if (oldJob.getEnabled().equals(BooleanType.FALSE)) {
			return;
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setEnabled(BooleanType.FALSE);
		newJob.setReady(BooleanType.TRUE);
		jobDao.update(newJob);
	}

	@JLFMVCTrans(dbName="?")
	@Override
	public void saveJob(Long templateId, Long billId, String cron, BooleanType enabled, JLFJson params) {
		QuartzJob job = new QuartzJob();
		job.setTemplateId(templateId);
		job.setBillId(billId);
		job.setCron(cron);
		job.setEnabled(enabled);
		if (params != null) {
			job.setParams(params.toStr());
		}
		saveJob(job);

	}

	@JLFMVCTrans(dbName="?")
	@Override
	public void updateJob(Long id, Long version, Long templateId, Long billId, String cron, BooleanType enabled,
			JLFJson params) {
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
		updateJob(job);

	}

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:����ģ��
	 * @param template
	 */
	@JLFMVCTrans(dbName="?")
	public QuartzTemplate saveTemplate(QuartzTemplate template) {
		QuartzTemplate oldTemplate = templateDao.getByTemplateName(template.getTemplateName());
		if (oldTemplate != null) {
			throw new JLFException("ģ�������ظ�");
		}
		return templateDao.save(template);

	}

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:����ģ��
	 * @param template
	 */
	@JLFMVCTrans(dbName="?")
	public void updateTemplate(QuartzTemplate template) {
		QuartzTemplate oldTemplate = templateDao.getByIdAndVersion(template.getId(), template.getVersion());
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
	@JLFMVCTrans(dbName="?")
	public void deleteTemplate(Long id, Long version) {
		QuartzTemplate template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
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
	@JLFMVCTrans(dbName="?")
	public void enabledTemplate(Long id, Long version) {
		QuartzTemplate template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
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
	@JLFMVCTrans(dbName="?")
	public void disabledTemplate(Long id, Long version) {
		QuartzTemplate template = templateDao.getByIdAndVersion(id, version);
		if (template == null) {
			throw new JLFException("ģ�岻����");
		}
		QuartzTemplate newQuartzTemplate = new QuartzTemplate();
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
	@JLFMVCTrans(dbName="?")
	public void saveLog(QuartzExecuteLog log) {
		logDao.save(log);
	}

}
