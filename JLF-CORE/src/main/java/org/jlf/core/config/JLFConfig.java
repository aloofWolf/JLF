package org.jlf.core.config;

import java.util.Properties;

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

	private static String configFilePath = PathUtil.getRootPath(); // 配置文件路径
	private static String configFileName = "JLF.ini"; // 配置文件名

	private static IniUtil jLFConfig; // 项目配置

	private static final String pluginConfigName = "plugin-%s";
	private static final String productConfigName = "product-%s";
	private static final String soaConfigName = "soa-%s";

	static {
		loadConfig();
	}

	/**
	 * 
	 * @Title: loadConfig
	 * @Description: 加载配置
	 */
	private static void loadConfig() {
		jLFConfig = new IniUtil(new StringBuffer(configFilePath).append(configFileName).toString());
	}

	/**
	 * 
	 * @Title: getPluginConfig
	 * @Description:获取某个插件的配置,不用重新加载配置文件
	 * @param pluginName
	 * @return
	 */
	public static Properties getPluginConfig(String pluginName) {
		return getPluginConfig(pluginName, false);
	}

	/**
	 * 
	 * @Title: getPluginConfig
	 * @Description: 获取某个插件的配置
	 * @param pluginName
	 * @param reLoadConfig
	 *            是否需要重新加载配置文件
	 * @return
	 */
	public static Properties getPluginConfig(String pluginName, boolean reLoadConfig) {

		if (reLoadConfig) {
			loadConfig();
		}
		return jLFConfig.getSection(String.format(pluginConfigName, pluginName));
	}

	/**
	 * 
	 * @Title: getProductConfig
	 * @Description:获取某个产品的配置,不用重新加载配置文件
	 * @param productName
	 * @return
	 */
	public static Properties getProductConfig(String productName) {
		return getProductConfig(productName, false);
	}

	/**
	 * 
	 * @Title: getProductConfig
	 * @Description: 获取某个产品的配置
	 * @param productName
	 * @param reLoadConfig
	 *            是否需要重新加载配置文件
	 * @return
	 */
	public static Properties getProductConfig(String productName, boolean reLoadConfig) {
		if (reLoadConfig) {
			loadConfig();
		}
		return jLFConfig.getSection(String.format(productConfigName, productName));
	}

	/**
	 * 
	 * @Title: getSoaConfigFilePath
	 * @Description:获取某个架构的配置,不用重新加载配置文件
	 * @param pluginName
	 * @return
	 */
	public static Properties getSoaConfig(String soaName) {
		return getSoaConfig(soaName, false);
	}

	/**
	 * 
	 * @Title: getSoaConfig
	 * @Description:获取某个架构的配置
	 * @param soaName
	 * @param reLoadConfig
	 *            是否需要重新加载配置文件
	 * @return
	 */
	public static Properties getSoaConfig(String soaName, boolean reLoadConfig) {
		if (reLoadConfig) {
			loadConfig();
		}
		return jLFConfig.getSection(String.format(soaConfigName, soaName));
	}
}
