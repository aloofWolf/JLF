package org.jlf.product.quartz.user.api;

import java.util.Map;

/**
 * 
 * @ClassName: JLFJob
 * @Description:QUARTZ JOB的具体执行,需调用者实现
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public interface JLFJob {

	/**
	 * 
	 * @Title: execute
	 * @Description:具体执行
	 * @param params
	 * @throws Exception
	 */
	public void execute(Map<String, Object> params) throws Exception;

}
