package org.jlf.product.ops.server.api;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFOps
 * @Description:JLFOpsApi
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public interface JLFOps extends JLFProductServerApi {

	/**
	 * 
	 * @Title: reLoadPluginConfigFile
	 * @Description:插件服务端重新加载配置文件
	 * @param clientCode
	 * @param serverCode
	 */
	public <SERVER_API extends JLFPluginServerApi> void reLoadPluginConfigFile(String clientCode, String serverCode);

	/**
	 * 
	 * @Title: reLoadProductConfigFile
	 * @Description:产品服务端重新加载配置文件
	 * @param clientCode
	 * @param serverCode
	 */
	public <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> void reLoadProductConfigFile(
			String clientCode, String serverCode);

	/**
	 * 
	 * @Title: reLoadSoaConfigFile
	 * @Description:架构服务端重新加载配置文件
	 * @param serverCode
	 */
	public void reLoadSoaConfigFile(String serverCode);

}
