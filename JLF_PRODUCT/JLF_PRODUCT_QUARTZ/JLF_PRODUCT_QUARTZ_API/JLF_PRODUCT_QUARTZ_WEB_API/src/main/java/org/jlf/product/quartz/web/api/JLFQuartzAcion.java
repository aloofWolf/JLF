package org.jlf.product.quartz.web.api;

import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFQuartzAcion
 * @Description:JLFQuartzAcion
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public interface JLFQuartzAcion extends JLFProductWebApi {

	/**
	 * 
	 * @Title: getDefineAction
	 * @Description:��ȡJLFQuartzDefineAction
	 * @return
	 */
	public abstract JLFQuartzDefineAction getDefineAction();

	/**
	 * 
	 * @Title: getQueryAction
	 * @Description:��ȡJLFQuartzQueryAction
	 * @return
	 */
	public abstract JLFQuartzQueryAction getQueryAction();

}
