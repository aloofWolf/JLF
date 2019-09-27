package org.jlf.product.server.core.log.custom.service;

import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.DirectSchedulerFactory;

/**
 * 
 * @ClassName: TableManagerService
 * @Description: TableManagerService
 * @author Lone Wolf
 * @date 2019年9月24日
 */
@JLFMVCService
public class TableManagerService {

	private Scheduler scheduler;
	private String quartzName = "log";
	private String corn = "0 10 0 1 * ?";

	/**
	 * 
	 * @Title: startQuartz
	 * @Description:启动定时任务
	 */
	public void startQuartz() {
		if (scheduler != null) { // 在log产品重新启动时,不用重新创建scheduler
			return;
		}
		DirectSchedulerFactory schedulerFactory = DirectSchedulerFactory.getInstance();
		try {
			schedulerFactory.createVolatileScheduler(1);
			scheduler = schedulerFactory.getScheduler();
			JobDetail jobDetail = JobBuilder.newJob(CreateTableService.class).withIdentity(quartzName, quartzName)
					.build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzName, quartzName).startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule(corn)).build();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
