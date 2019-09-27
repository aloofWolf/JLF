package org.jlf.product.quartz.user.api;

import java.util.Map;

/**
 * 
 * @ClassName: JLFQuartzJob
 * @Description:QUARTZ JOB�ľ���ִ��,�������ʵ��
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public interface JLFQuartzJob {

	/**
	 * 
	 * @Title: execute
	 * @Description:����ִ��
	 * @param params
	 * @throws Exception
	 */
	public void execute(Map<String, Object> params) throws Exception;

}
