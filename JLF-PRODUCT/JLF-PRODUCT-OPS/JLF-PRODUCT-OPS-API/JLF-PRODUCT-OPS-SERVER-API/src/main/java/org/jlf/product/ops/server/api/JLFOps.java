package org.jlf.product.ops.server.api;

import org.jlf.core.api.JLFProductServerApi;

/**
 * 
 * @ClassName: JLFOps
 * @Description:JLFOpsApi
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public interface JLFOps extends JLFProductServerApi {
	
	public static final String PRODUCT_NAME = "ops";

	/**
	 * 
	 * @Title: getJLFOpsExecute
	 * @Description: ��ȡJLFOpsExecute
	 * @return
	 */
	public JLFOpsExecute getJLFOpsExecute();

	/**
	 * 
	 * @Title: getJLFOpsQuery
	 * @Description: ��ȡJLFOpsExecute
	 * @return
	 */
	public JLFOpsQuery getJLFOpsQuery();

}
