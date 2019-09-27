package org.jlf.product.server.core.log.custom.service;

import org.jlf.common.util.LogUtil;
import org.jlf.product.server.core.log.custom.dao.LogDao;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @ClassName: CreateTableService
 * @Description: 创建新表的job
 * @author Lone Wolf
 * @date 2019年9月24日
 */
public class CreateTableService implements Job {

	private LogDao dao = JLFMVCBeanContainer.get(LogDao.class);

	/**
	 * 创建新表逻辑
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LogUtil.get().debug("创建新表任务开始执行");
		try {
			dao.createNewTable();
		} catch (Throwable e) {
			e.printStackTrace();
			LogUtil.get().debug("创建新表任务开始执行失败");
		}
		LogUtil.get().debug("创建新表任务开始执行成功");

	}

}
