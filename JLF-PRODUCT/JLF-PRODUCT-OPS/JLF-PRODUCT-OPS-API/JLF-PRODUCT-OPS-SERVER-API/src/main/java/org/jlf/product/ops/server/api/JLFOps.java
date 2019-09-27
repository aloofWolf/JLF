package org.jlf.product.ops.server.api;

import org.jlf.core.api.JLFProductServerApi;

/**
 * 
 * @ClassName: JLFOps
 * @Description:JLFOpsApi
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public interface JLFOps extends JLFProductServerApi {
	
	public static final String PRODUCT_NAME = "ops";

	/**
	 * 
	 * @Title: getJLFOpsExecute
	 * @Description: 获取JLFOpsExecute
	 * @return
	 */
	public JLFOpsExecute getJLFOpsExecute();

	/**
	 * 
	 * @Title: getJLFOpsQuery
	 * @Description: 获取JLFOpsExecute
	 * @return
	 */
	public JLFOpsQuery getJLFOpsQuery();

}
