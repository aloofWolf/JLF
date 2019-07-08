package org.jlf.product.ops.web.api;

import org.jlf.product.ops.web.api.metadata.request.JLFOpsDriverRequest;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;

/**
 * 
 * @ClassName: JLFOpsDriverAction
 * @Description:JLFOpsDriverActionApi
 * @author Lone Wolf
 * @date 2019年7月6日
 */
@JLFMVCRouteCls(name = "opsDriver")
public interface JLFOpsDriverAction {

	/**
	 * 
	 * @Title: reLoadPluginConfigFile
	 * @Description:插件服务端重新加载配置文件
	 * @param serverCode
	 */
	public void reLoadPluginConfigFile(JLFOpsDriverRequest req);

	/**
	 * 
	 * @Title: reLoadProductConfigFile
	 * @Description:插件服务端重新加载配置文件
	 * @param serverCode
	 */
	public void reLoadProductConfigFile(JLFOpsDriverRequest req);

	/**
	 * 
	 * @Title: reLoadSoaConfigFile
	 * @Description:架构服务端重新加载配置文件
	 * @param serverCode
	 */
	public void reLoadSoaConfigFile(JLFOpsDriverRequest req);

}
