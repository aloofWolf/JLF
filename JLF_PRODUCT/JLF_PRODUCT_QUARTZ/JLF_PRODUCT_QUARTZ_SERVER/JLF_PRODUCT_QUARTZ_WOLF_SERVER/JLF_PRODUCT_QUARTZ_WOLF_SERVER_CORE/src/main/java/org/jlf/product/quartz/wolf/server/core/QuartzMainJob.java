package org.jlf.product.quartz.wolf.server.core;

import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.service.QuartzJobService;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @ClassName: QuartzMainJob
 * @Description:主任务
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class QuartzMainJob implements Job {

	private QuartzJobService jobService = JLFMVCServiceStruc.getService(QuartzJobService.class);

	/**
	 * 主任务执行
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		String dbNames = QuartzJobManager.dbNames;
		String[] arr = dbNames.split(",");
		for (String dbName : arr) {
			executeDb(dbName);
		}
		

	}
	
	private void executeDb(String dbName){
		JLFMVCThreadLocal.setDbName(dbName);
		List<QuartzJob> jobs = null;
		try {
			jobs = jobService.getReadyList(BooleanType.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jobs != null) {
			for (QuartzJob job : jobs) {
				try {
					QuartzJobManager.schedulerJob(job);
					job.setReady(BooleanType.FALSE);
					QuartzJob updateJob = new QuartzJob();
					updateJob.setId(job.getId());
					updateJob.setVersion(job.getVersion());
					updateJob.setReady(BooleanType.FALSE);
					jobService.update(updateJob);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
		JLFMVCThreadLocal.setDbName(null);
	}

}
