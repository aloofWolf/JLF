package org.jlf.product.quartz.wolf.server.core;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
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
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.DirectSchedulerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: QuartzJobManager
 * @Description:Job����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class QuartzJobManager {

	private static Scheduler scheduler;
	private static int seconds;
	private static String mainCron;
	protected static String dbNames;

	/**
	 * 
	 * @Title: init
	 * @Description:���ݳ�ʼ��
	 * @param config
	 * @throws Exception
	 */
	public static void init(QuartzConfig config) throws Exception {
		seconds = config.getSeconds();
		DirectSchedulerFactory schedulerFactory = DirectSchedulerFactory.getInstance();
		schedulerFactory.createVolatileScheduler(config.getMaxThreads());
		scheduler = schedulerFactory.getScheduler();
		mainCron = String.format("*/%s * * * * ?", seconds);
		dbNames = config.getDbNames();
	}

	/**
	 * 
	 * @Title: addJob
	 * @Description:���һ������
	 * @param quartzJob
	 * @throws Exception
	 */
	public static void addJob(QuartzJob quartzJob) throws Exception {

		String dbName = JLFMVCThreadLocal.getDbName();
		@SuppressWarnings("unchecked")
		Class<? extends Job> jobCls = (Class<? extends Job>) Class.forName(quartzJob.getStr("clsName"));
		JLFJob job = (JLFJob) jobCls.newInstance();
		JobDetail jobDetail = JobBuilder.newJob(JLFQuartzWolfJob.class).withIdentity(dbName, quartzJob.getId().toString()).build();
		JobDataMap jobMap = jobDetail.getJobDataMap();
		String paramsJsonStr = quartzJob.getParams();
		@SuppressWarnings("unchecked")
		Map<String, Object> mapObj = JSONObject.parseObject(paramsJsonStr, Map.class);
		if(mapObj != null){
			jobMap.putAll(mapObj);
		}
		
		jobMap.put("dbName", dbName);
		jobMap.put("JLFJob", job);
		jobMap.put("quartzJob", quartzJob);

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(dbName, quartzJob.getId().toString()).startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCron())).build();

		scheduler.scheduleJob(jobDetail, trigger);
	}

	/**
	 * 
	 * @Title: schedulerJob
	 * @Description:����һ������
	 * @param quartzJob
	 * @throws Exception
	 */
	public static void schedulerJob(QuartzJob quartzJob) throws Exception {
		String dbName = JLFMVCThreadLocal.getDbName();
		JobKey key = new JobKey(dbName, quartzJob.getId().toString());
		if (scheduler.checkExists(key)) {
			scheduler.deleteJob(key);
		}
		if (BooleanType.TRUE.equals(quartzJob.getEnabled())) {
			addJob(quartzJob);
		}
	}

	/**
	 * 
	 * @Title: addMainjob
	 * @Description:���������,������scheduler
	 * @throws Exception
	 */
	public static void addMainjob() throws Exception {
		JobDetail jobDetail = JobBuilder.newJob(QuartzMainJob.class).withIdentity("LoneWolf", "-1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("LoneWolf", "-1").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(mainCron)).build();

		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}

}
