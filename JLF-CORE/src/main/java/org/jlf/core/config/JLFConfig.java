package org.jlf.core.config;

import org.jlf.common.util.PathUtil;

/**
 * 
 * @ClassName: JLFConfig
 * @Description:JLL配置
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class JLFConfig {

	private static String configPath; // 配置文件路径

	/**
	 * 初始化读取并解析总配置文件
	 */
	static {
		configPath = PathUtil.getConfigFilePath();
	}

	/**
	 * 
	 * @Title: getPluginConfigFilePath
	 * @Description:获取某个插件的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getPluginConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("PLUGINS/").append(configFileName).toString();
	}

	/**
	 * 
	 * @Title: getProductConfigFilePath
	 * @Description:获取某个产品的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getProductConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("PRODUCTS/").append(configFileName).toString();
	}

	/**
	 * 
	 * @Title: getSoaConfigFilePath
	 * @Description:获取某个架构的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getSoaConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("SOAS/").append(configFileName).toString();
	}
}
