package org.jlf.product.ops.web.api;

import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFOpsAction
 * @Description:JLFOpsActionApi
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public interface JLFOpsAction extends JLFProductWebApi {

	/**
	 * 
	 * @Title: getOpsDriverAction
	 * @Description:获取JLFOpsDriverAction
	 * @return
	 * @throws Exception
	 */
	public JLFOpsExecuteAction getOpsDriverAction() throws Exception;

	/**
	 * 
	 * @Title: getOpsQueryAction
	 * @Description:获取JLFOpsQueryAction
	 * @return
	 * @throws Exception
	 */
	public JLFOpsQueryAction getOpsQueryAction() throws Exception;

}
