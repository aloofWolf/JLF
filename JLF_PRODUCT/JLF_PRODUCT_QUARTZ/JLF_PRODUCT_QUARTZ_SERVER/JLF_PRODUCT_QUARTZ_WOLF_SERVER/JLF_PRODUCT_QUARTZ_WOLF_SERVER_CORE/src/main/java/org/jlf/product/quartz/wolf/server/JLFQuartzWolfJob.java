package org.jlf.product.quartz.wolf.server;

import java.util.Date;

import org.jlf.common.util.LogUtil;
import org.jlf.product.quartz.user.api.JLFJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.enums.QuartzExecuteResult;
import org.jlf.product.quartz.wolf.server.service.QuartzDefineService;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

/**
 * 
 * @ClassName: JLFQuartzWolfJob
 * @Description:JLFQuartzWolfJob
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFQuartzWolfJob implements Job {

	private QuartzDefineService defineService = JLFMVCServiceStruc.getService(QuartzDefineService.class);


	/**
	 * 执行任务
	 */
	@Override
	public void execute(JobExecutionContext context) {
		Date startTime = new Date();
		QuartzExecuteResult executeResult = QuartzExecuteResult.SUCCESS;
		String failReason = null;
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String dbName = jobDataMap.getString("dbName");
		JLFMVCThreadLocal.setDbName(dbName);
		QuartzJob quartzJob = (QuartzJob) jobDataMap.get("quartzJob");
		JLFJob job = (JLFJob) jobDataMap.get("JLFJob");
		LogUtil.get().debug("定时任务:{}开始执行,dbName:{},id:{}", quartzJob.getStr("templateName"), dbName, quartzJob.getId());
		try {
			job.execute(jobDataMap);
			LogUtil.get().debug("定时任务:{}执行成功,dbName:{},id:{}", quartzJob.getStr("templateName"), dbName,
					quartzJob.getId());
		} catch (Exception e) {
			e.printStackTrace();
			executeResult = QuartzExecuteResult.FAIL;
			failReason = e.getMessage();
			if (failReason == null || failReason.length() == 0) {
				failReason = "系统错误";
			}
			LogUtil.get().debug("定时任务:{}执行异常,dbName:{},id:{}", quartzJob.getStr("templateName"), dbName,
					quartzJob.getId());
		} finally {
			Date endTime = new Date();
			saveExecuteLog(dbName, quartzJob, startTime, endTime, executeResult, failReason);
		}

	}

	/**
	 * 
	 * @Title: saveExecuteLog
	 * @Description:记录日志
	 * @param dbName
	 * @param job
	 * @param startTime
	 * @param endTime
	 * @param executeResult
	 * @param failReason
	 */
	private void saveExecuteLog(String dbName, QuartzJob job, Date startTime, Date endTime,
			QuartzExecuteResult executeResult, String failReason) {
		try {
			QuartzExecuteLog executeLog = new QuartzExecuteLog();
			executeLog.setTemplateId(job.getTemplateId());
			executeLog.setTemplateName(job.getStr("templateName"));
			executeLog.setTemplateClsName(job.getStr("clsName"));
			executeLog.setJobId(job.getId());
			executeLog.setBillId(job.getBillId());
			executeLog.setParams(job.getParams());
			executeLog.setStartTime(startTime);
			executeLog.setEndTime(endTime);
			executeLog.setExecuteResult(executeResult);
			executeLog.setFailReason(failReason);
			defineService.saveLog(executeLog);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug("定时任务:{}记录日志失败,dbName:{},id:{}", job.getStr("templateName"), dbName, job.getId());
		}

	}

}
