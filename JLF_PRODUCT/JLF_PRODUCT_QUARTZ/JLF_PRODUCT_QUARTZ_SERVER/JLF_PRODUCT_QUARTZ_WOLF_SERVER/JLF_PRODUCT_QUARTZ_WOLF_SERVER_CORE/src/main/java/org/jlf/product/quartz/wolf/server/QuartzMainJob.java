package org.jlf.product.quartz.wolf.server;

import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.service.QuartzDefineService;
import org.jlf.product.quartz.wolf.server.service.QuartzQueryService;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * 
 * @ClassName: QuartzMainJob
 * @Description:������
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class QuartzMainJob implements Job {

	private QuartzDefineService defineService = JLFMVCServiceStruc.getService(QuartzDefineService.class);
	private QuartzQueryService queryService = JLFMVCServiceStruc.getService(QuartzQueryService.class);

	/**
	 * ������ִ��
	 */
	@Override
	public void execute(JobExecutionContext context) {

		String dbNames = QuartzJobManager.config.getDbNames();
		String[] arr = dbNames.split(",");
		for (String dbName : arr) {
			executeDb(dbName);
		}
	}

	/**
	 * 
	 * @Title: executeDb
	 * @Description:�������õ��������ݿ�,�������Ѿ���״̬������
	 * @param dbName
	 */
	private void executeDb(String dbName) {
		JLFMVCThreadLocal.setDbName(dbName);
		List<QuartzJob> jobs = null;
		try {
			jobs = queryService.getReadyJobList(BooleanType.TRUE);
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
					defineService.updateJob(updateJob);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
		JLFMVCThreadLocal.setDbName(null);
	}

}
