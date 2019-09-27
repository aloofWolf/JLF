package org.jlf.product.server.quartz.custom;

import java.util.Date;

import org.jlf.common.util.HostUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.product.quartz.user.api.JLFQuartzJob;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.enums.JLFQuartzExecuteResult;
import org.jlf.product.server.core.quartz.custom.service.QuartzDefineService;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

/**
 * 
 * @ClassName: JLFQuartzWolfJob
 * @Description:JLFQuartzWolfJob
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class JLFQuartzCustomJob implements Job {

	private QuartzDefineService defineService = JLFMVCBeanContainer.get(QuartzDefineService.class);

	/**
	 * ִ������
	 */
	@Override
	public void execute(JobExecutionContext context) {
		Date startTime = new Date();
		JLFQuartzExecuteResult executeResult = JLFQuartzExecuteResult.SUCCESS;
		String failReason = null;
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String dbName = jobDataMap.getString("dbName");
		JLFMVCThreadLocal.setDbName(dbName);
		JLFQuartzJobEntity quartzJobEntity = (JLFQuartzJobEntity) jobDataMap.get("quartzJob");
		JLFQuartzJob job = (JLFQuartzJob) jobDataMap.get("JLFJob");
		LogUtil.get().debug("��ʱ����:{}��ʼִ��,dbName:{},id:{}", quartzJobEntity.getTemplate().getTemplateName(), dbName,
				quartzJobEntity.getId());
		try {
			job.execute(jobDataMap);
			LogUtil.get().debug("��ʱ����:{}ִ�гɹ�,dbName:{},id:{}", quartzJobEntity.getTemplate().getTemplateName(), dbName,
					quartzJobEntity.getId());
		} catch (Exception e) {
			e.printStackTrace();
			executeResult = JLFQuartzExecuteResult.FAIL;
			failReason = e.getMessage();
			if (failReason == null || failReason.length() == 0) {
				failReason = "ϵͳ����";
			}
			LogUtil.get().debug("��ʱ����:{}ִ���쳣,dbName:{},id:{},�쳣��Ϣ:{}", quartzJobEntity.getTemplate().getTemplateName(), dbName,
					quartzJobEntity.getId(),failReason);
		} finally {
			Date endTime = new Date();
			saveExecuteLog(dbName, quartzJobEntity, startTime, endTime, executeResult, failReason);
		}

	}

	/**
	 * 
	 * @Title: saveExecuteLog
	 * @Description:��¼��־
	 * @param dbName
	 * @param job
	 * @param startTime
	 * @param endTime
	 * @param executeResult
	 * @param failReason
	 */
	private void saveExecuteLog(String dbName, JLFQuartzJobEntity job, Date startTime, Date endTime,
			JLFQuartzExecuteResult executeResult, String failReason) {
		try {
			JLFQuartzExecuteLogEntity executeLog = new JLFQuartzExecuteLogEntity();
			executeLog.setTemplateId(job.getTemplateId());
			executeLog.setTemplateName(job.getTemplate().getTemplateName());
			executeLog.setTemplateClsName(job.getTemplate().getClsName());
			executeLog.setJobId(job.getId());
			executeLog.setHostIp(HostUtil.getCurrHostIp());
			executeLog.setParams(job.getParams());
			executeLog.setStartTime(startTime);
			executeLog.setEndTime(endTime);
			executeLog.setExecuteResult(executeResult);
			executeLog.setFailReason(failReason);
			defineService.saveLog(executeLog);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug("��ʱ����:{}��¼��־ʧ��,dbName:{},id:{}", job.getTemplate().getTemplateName(), dbName,
					job.getId());
		}

	}

}
