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
 * @date 2019��9��24��
 */
@JLFMVCService
public class TableManagerService {

	private Scheduler scheduler;
	private String quartzName = "log";
	private String corn = "0 10 0 1 * ?";

	/**
	 * 
	 * @Title: startQuartz
	 * @Description:������ʱ����
	 */
	public void startQuartz() {
		if (scheduler != null) { // ��log��Ʒ��������ʱ,�������´���scheduler
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
