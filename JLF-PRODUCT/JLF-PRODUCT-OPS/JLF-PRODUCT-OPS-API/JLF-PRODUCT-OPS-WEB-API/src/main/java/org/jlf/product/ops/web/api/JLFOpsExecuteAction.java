package org.jlf.product.ops.web.api;

import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFOpsExecuteAction
 * @Description:JLFOpsExecuteActionApi
 * @author Lone Wolf
 * @date 2019年7月6日
 */
@JLFMVCRoute(name = "opsDriver")
public interface JLFOpsExecuteAction {

	/**
	 * 
	 * @Title: reStartPluginServer
	 * @Description: 重新启动插件服务端
	 * @param pluginServerClsName
	 */
	public void reStartPluginServer(String pluginServerClsName);

	/**
	 * 
	 * @Title: reStartProductServer
	 * @Description:重新启动产品服务端
	 * @param productServerClsName
	 */
	public void reStartProductServer(String productServerClsName);

	/**
	 * 
	 * @Title: reStartSoaServer
	 * @Description: 重新启动架构服务端
	 * @param soaServerClsName
	 */
	public void reStartSoaServer(String soaServerClsName);

}
