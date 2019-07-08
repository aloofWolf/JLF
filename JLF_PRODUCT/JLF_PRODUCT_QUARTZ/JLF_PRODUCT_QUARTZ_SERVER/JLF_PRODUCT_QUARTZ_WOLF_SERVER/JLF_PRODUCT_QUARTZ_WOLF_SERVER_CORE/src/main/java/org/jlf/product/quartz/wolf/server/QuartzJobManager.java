package org.jlf.product.quartz.wolf.server;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.common.exception.JLFException;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.product.quartz.user.api.JLFJob;
import org.jlf.product.quartz.wolf.server.config.QuartzConfig;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
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
import org.quartz.impl.DirectSchedulerFactory;

/**
 * 
 * @ClassName: QuartzJobManager
 * @Description:Job����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class QuartzJobManager {

	private static Scheduler scheduler;
	protected static QuartzConfig config;

	/**
	 * 
	 * @Title: init
	 * @Description:���ݳ�ʼ��
	 * @param config
	 * @
	 */
	public static void init(QuartzConfig config)  {
		DirectSchedulerFactory schedulerFactory = DirectSchedulerFactory.getInstance();
		try {
			schedulerFactory.createVolatileScheduler(config.getMaxThreads());
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		QuartzJobManager.config = config;
	}

	/**
	 * 
	 * @Title: addJob
	 * @Description:���һ������
	 * @param quartzJob
	 * @
	 */
	@SuppressWarnings("unchecked")
	public static void addJob(QuartzJob quartzJob)  {

		String dbName = JLFMVCThreadLocal.getDbName();
		Class<? extends Job> jobCls;
		JLFJob job;
		try {
			jobCls = (Class<? extends Job>) Class.forName(quartzJob.getStr("clsName"));
			job = (JLFJob) jobCls.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		
		JobDetail jobDetail = JobBuilder.newJob(JLFQuartzWolfJob.class).withIdentity(dbName, quartzJob.getId().toString()).build();
		JobDataMap jobMap = jobDetail.getJobDataMap();
		String paramsJsonStr = quartzJob.getParams();
		Map<String, Object> mapObj = JLFJsonClient.get().jsonStrToMap(paramsJsonStr);
		if(mapObj != null){
			jobMap.putAll(mapObj);
		}
		
		jobMap.put("dbName", dbName);
		jobMap.put("JLFJob", job);
		jobMap.put("quartzJob", quartzJob);

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(dbName, quartzJob.getId().toString()).startNow()
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
	 * @Description:����һ������
	 * @param quartzJob
	 * @
	 */
	public static void schedulerJob(QuartzJob quartzJob)  {
		String dbName = JLFMVCThreadLocal.getDbName();
		JobKey key = new JobKey(dbName, quartzJob.getId().toString());
		try {
			if (scheduler.checkExists(key)) {
				scheduler.deleteJob(key);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		if (BooleanType.TRUE.equals(quartzJob.getEnabled())) {
			addJob(quartzJob);
		}
	}

	/**
	 * 
	 * @Title: addMainjob
	 * @Description:���������,������scheduler
	 */
	public static void addMainjob()  {
		String mainCron = String.format("*/%s * * * * ?", config.getSeconds());
		JobDetail jobDetail = JobBuilder.newJob(QuartzMainJob.class).withIdentity("LoneWolf", "-1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("LoneWolf", "-1").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(mainCron)).build();

		try {
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		
	}

}
