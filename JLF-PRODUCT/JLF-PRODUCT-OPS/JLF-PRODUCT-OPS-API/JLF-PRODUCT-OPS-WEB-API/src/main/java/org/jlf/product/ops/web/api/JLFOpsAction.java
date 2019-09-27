package org.jlf.product.ops.web.api;

import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFOpsAction
 * @Description:JLFOpsActionApi
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public interface JLFOpsAction extends JLFProductWebApi {

	/**
	 * 
	 * @Title: getOpsDriverAction
	 * @Description:��ȡJLFOpsDriverAction
	 * @return
	 * @throws Exception
	 */
	public JLFOpsExecuteAction getOpsDriverAction() throws Exception;

	/**
	 * 
	 * @Title: getOpsQueryAction
	 * @Description:��ȡJLFOpsQueryAction
	 * @return
	 * @throws Exception
	 */
	public JLFOpsQueryAction getOpsQueryAction() throws Exception;

}
