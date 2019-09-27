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
 * @Description: �����±��job
 * @author Lone Wolf
 * @date 2019��9��24��
 */
public class CreateTableService implements Job {

	private LogDao dao = JLFMVCBeanContainer.get(LogDao.class);

	/**
	 * �����±��߼�
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LogUtil.get().debug("�����±�����ʼִ��");
		try {
			dao.createNewTable();
		} catch (Throwable e) {
			e.printStackTrace();
			LogUtil.get().debug("�����±�����ʼִ��ʧ��");
		}
		LogUtil.get().debug("�����±�����ʼִ�гɹ�");

	}

}
