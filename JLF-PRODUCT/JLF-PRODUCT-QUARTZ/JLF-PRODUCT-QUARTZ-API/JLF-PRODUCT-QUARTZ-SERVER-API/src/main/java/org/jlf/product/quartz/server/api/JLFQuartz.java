package org.jlf.product.quartz.server.api;

import org.jlf.core.api.JLFProductServerApi;

/**
 * 
 * @ClassName: JLFQuartz
 * @Description:JLFQuartz api
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public interface JLFQuartz extends JLFProductServerApi {

	public static final String PRODUCT_NAME = "quartz";

	/**
	 * 
	 * @Title: getQuartzDefine
	 * @Description:��ȡJLFQuartzDefine
	 * @return
	 */
	public JLFQuartzDefine getQuartzDefine();

	/**
	 * 
	 * @Title: getQuartzQuery
	 * @Description:��ȡJLFQuartzQuery
	 * @return
	 */
	public JLFQuartzQuery getQuartzQuery();

}
