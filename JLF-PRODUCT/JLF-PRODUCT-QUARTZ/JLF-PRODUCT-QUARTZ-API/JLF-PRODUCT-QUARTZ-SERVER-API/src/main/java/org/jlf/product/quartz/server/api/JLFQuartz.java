package org.jlf.product.quartz.server.api;

import org.jlf.core.api.JLFProductServerApi;

/**
 * 
 * @ClassName: JLFQuartz
 * @Description:JLFQuartz api
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public interface JLFQuartz extends JLFProductServerApi {

	public static final String PRODUCT_NAME = "quartz";

	/**
	 * 
	 * @Title: getQuartzDefine
	 * @Description:获取JLFQuartzDefine
	 * @return
	 */
	public JLFQuartzDefine getQuartzDefine();

	/**
	 * 
	 * @Title: getQuartzQuery
	 * @Description:获取JLFQuartzQuery
	 * @return
	 */
	public JLFQuartzQuery getQuartzQuery();

}
