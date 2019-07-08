package org.jlf.core.config;

import org.jlf.common.enums.CodeEnvironment;
import org.jlf.common.util.IniUtil;
import org.jlf.common.util.PathUtil;

/**
 * 
 * @ClassName: JLFConfig
 * @Description:JLL配置
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class JLFConfig {

	private static String configFileName = "jlf.ini"; // 全局配置文件名称
	private static String configPath; // 配置文件路径
	private static IniUtil JLFConfig; // 配置文件的ini
	private static CodeEnvironment codeEnvironment; // 当前代码环境
	private static String serverJarPath;

	/**
	 * 初始化读取并解析总配置文件
	 */
	static {
		configPath = PathUtil.getConfigFilePath();
		try {
			JLFConfig = new IniUtil(new StringBuffer(configPath).append(configFileName).toString());
			String codeEnvironmentStr = JLFConfig.getValue("codeEnvironment");
			if (codeEnvironmentStr == null || codeEnvironmentStr.length() == 0) {
				throw new Exception("未配置当前代码环境codeEnvironment");
			}
			codeEnvironment = CodeEnvironment.valueOf(codeEnvironmentStr);
			serverJarPath = JLFConfig.getValue("serverJarPath");
			if (serverJarPath == null) {
				throw new Exception("未配置服务端jar包路径serverJarPath");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getConfigFileName
	 * @Description:获取jlf配置文件名称
	 * @return
	 */
	public static String getConfigFileName() {
		return configFileName;
	}

	/**
	 * 
	 * @Title: getConfigPath
	 * @Description:获取配置文件路径
	 * @return
	 */
	public static String getConfigPath() {
		return configPath;
	}

	/**
	 * 
	 * @Title: getJAFConfig
	 * @Description:获取JAF的配置信息
	 * @return
	 */
	public static IniUtil getJLFConfig() {
		return JLFConfig;
	}

	/**
	 * 
	 * @Title: getPluginConfigName
	 * @Description:获取某个插件的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getPluginConfigName(String pluginName) {
		return new StringBuffer(configPath).append(codeEnvironment).append("/").append("PLUGINS/")
				.append(JLFConfig.getValue("pluginsConfig", pluginName)).toString();
	}

	/**
	 * 
	 * @Title: getProductConfigName
	 * @Description:获取某个产品的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getProductConfigName(String productName) {
		return new StringBuffer(configPath).append(codeEnvironment).append("/").append("PRODUCTS/")
				.append(JLFConfig.getValue("productsConfig", productName)).toString();
	}

	/**
	 * 
	 * @Title: getSoaConfigName
	 * @Description:获取某个架构的配置文件路径
	 * @param pluginName
	 * @return
	 */
	public static String getSoaConfigName(String soaName) {
		return new StringBuffer(configPath).append(codeEnvironment).append("/").append("SOAS/")
				.append(JLFConfig.getValue("soasConfig", soaName)).toString();
	}

	/**
	 * 
	 * @Title: getCodeEnvironment
	 * @Description:获取当前代码环境
	 * @return
	 */
	public static CodeEnvironment getCodeEnvironment() {
		return codeEnvironment;
	}

	/**
	 * 
	 * @Title: getServerJarPath
	 * @Description:获取服务端jar包的存放路径
	 * @return
	 */
	public static String getServerJarPath() {
		return serverJarPath;
	}
}
