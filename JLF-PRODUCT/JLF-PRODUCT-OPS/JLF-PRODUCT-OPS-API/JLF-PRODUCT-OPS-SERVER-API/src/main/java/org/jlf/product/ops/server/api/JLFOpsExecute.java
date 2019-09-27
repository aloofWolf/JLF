package org.jlf.product.ops.server.api;

/**
 * 
 * @ClassName: JLFOpsExecute
 * @Description:JLFOpsExecuteApi
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public interface JLFOpsExecute {

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
