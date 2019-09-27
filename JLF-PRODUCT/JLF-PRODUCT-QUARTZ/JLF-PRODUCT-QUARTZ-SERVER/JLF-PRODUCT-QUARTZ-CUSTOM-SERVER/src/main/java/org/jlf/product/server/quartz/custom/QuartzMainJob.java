package org.jlf.product.server.quartz.custom;

import java.util.Date;
import java.util.List;

import org.jlf.common.util.LogUtil;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.server.core.quartz.custom.service.QuartzQueryService;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
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

	private QuartzQueryService queryService = JLFMVCBeanContainer.get(QuartzQueryService.class);

	/**
	 * ������ִ��
	 */
	@Override
	public void execute(JobExecutionContext context) {
		LogUtil.get().debug("������ʼִ��");
		Date now = new Date();

		List<JLFQuartzJobEntity> jobs = queryService.getList(QuartzJobManager.mainJobLastExecuteTime);
		int failCount = 0;
		if (jobs != null) {
			for (JLFQuartzJobEntity job : jobs) {
				try {
					QuartzJobManager.schedulerJob(job);
				} catch (Exception e) {
					e.printStackTrace();
					failCount = failCount + 1;
					continue;
				}
			}
		}
		if (failCount == 0) {
			QuartzJobManager.mainJobLastExecuteTime = now;
		}
		LogUtil.get().debug("������ִ�н���");
	}
}
