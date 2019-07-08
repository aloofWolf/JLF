package org.jlf.product.quartz.web.api;

import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFQuartzAcion
 * @Description:JLFQuartzAcion
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public interface JLFQuartzAcion extends JLFProductWebApi {

	/**
	 * 
	 * @Title: getDefineAction
	 * @Description:获取JLFQuartzDefineAction
	 * @return
	 */
	public abstract JLFQuartzDefineAction getDefineAction();

	/**
	 * 
	 * @Title: getQueryAction
	 * @Description:获取JLFQuartzQueryAction
	 * @return
	 */
	public abstract JLFQuartzQueryAction getQueryAction();

}
