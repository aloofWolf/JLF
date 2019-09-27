package org.jlf.product.server.quartz.custom;

import java.util.Date;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.util.DateUtil;
import org.jlf.common.util.HostUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.product.quartz.user.api.JLFQuartzJob;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.server.core.quartz.custom.config.QuartzConfig;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.DirectSchedulerFactory;

/**
 * 
 * @ClassName: QuartzJobManager
 * @Description:Job管理
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class QuartzJobManager {

	protected static Date mainJobLastExecuteTime = DateUtil.formatDate("2000-01-01 00:00:00", DateUtil.DEFAULT_DATETIMEPATTERN);// 主任务的上一次执行时间
	private static Scheduler scheduler;
	protected static QuartzConfig config;
	private static final JobKey mainJobKey = new JobKey("MAIN_JOB", "MAIN_JOB");
	private static final TriggerKey mainTriggerKey = new TriggerKey("MAIN_JOB", "MAIN_JOB");

	/**
	 * 
	 * @Title: init
	 * @Description:数据初始化
	 * @param config
	 * @
	 */
	public static void init(QuartzConfig config) {
		if (scheduler == null) { // 在重新时,不用重新加载scheduler
			DirectSchedulerFactory schedulerFactory = DirectSchedulerFactory.getInstance();
			try {
				schedulerFactory.createVolatileScheduler(config.getMaxThreads());
				scheduler = schedulerFactory.getScheduler();
			} catch (SchedulerException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}

		QuartzJobManager.config = config;
	}

	/**
	 * 
	 * @Title: addJob
	 * @Description:添加一个任务
	 * @param quartzJob
	 * @
	 */
	@SuppressWarnings("unchecked")
	public static void addJob(JLFQuartzJobEntity quartzJob) {

		Class<? extends Job> jobCls;
		JLFQuartzJob job;
		try {
			jobCls = (Class<? extends Job>) Class.forName(quartzJob.getTemplate().getClsName());
			job = (JLFQuartzJob) jobCls.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		JobDetail jobDetail = JobBuilder.newJob(JLFQuartzCustomJob.class)
				.withIdentity(quartzJob.getGroupName(), quartzJob.getId().toString()).build();
		JobDataMap jobMap = jobDetail.getJobDataMap();
		String paramsJsonStr = quartzJob.getParams();
		Map<String, Object> mapObj = JLFJsonClient.get().jsonStrToMap(paramsJsonStr);
		if (mapObj != null) {
			jobMap.putAll(mapObj);
		}

		jobMap.put("JLFJob", job);
		jobMap.put("quartzJobId", quartzJob.getId());

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzJob.getGroupName(), quartzJob.getId().toString()).startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCron())).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: schedulerJob
	 * @Description:调度一个任务
	 * @param quartzJob
	 * @
	 */
	public static void schedulerJob(JLFQuartzJobEntity job) {
		JobKey key = new JobKey(job.getGroupName(), job.getId().toString());
		try {
			if (scheduler.checkExists(key)) {
				scheduler.deleteJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		if (BooleanType.TRUE.equals(job.getEnabled()) && HostUtil.getCurrHostIp().equals(job.getHostIp()) && BooleanType.TRUE.equals(job.getTemplate().getEnabled())) {
			addJob(job);
		}
	}

	/**
	 * 
	 * @Title: addMainjob
	 * @Description:添加主任务,并启动scheduler
	 */
	public static void addMainjob() {
		String mainCron = String.format("*/%s * * * * ?", config.getSeconds());
		JobDetail jobDetail = JobBuilder.newJob(QuartzMainJob.class).withIdentity(mainJobKey).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(mainTriggerKey).startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(mainCron)).build();

		try {
			if (scheduler.checkExists(mainJobKey)) {
				scheduler.deleteJob(mainJobKey);
			}
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

}
