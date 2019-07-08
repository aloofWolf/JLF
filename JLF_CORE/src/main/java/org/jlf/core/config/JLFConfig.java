package org.jlf.core.config;

import org.jlf.common.enums.CodeEnvironment;
import org.jlf.common.util.IniUtil;
import org.jlf.common.util.PathUtil;

/**
 * 
 * @ClassName: JLFConfig
 * @Description:JLL����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class JLFConfig {

	private static String configFileName = "jlf.ini"; // ȫ�������ļ�����
	private static String configPath; // �����ļ�·��
	private static IniUtil JLFConfig; // �����ļ���ini
	private static CodeEnvironment codeEnvironment; // ��ǰ���뻷��
	private static String serverJarPath;

	/**
	 * ��ʼ����ȡ�������������ļ�
	 */
	static {
		configPath = PathUtil.getConfigFilePath();
		try {
			JLFConfig = new IniUtil(new StringBuffer(configPath).append(configFileName).toString());
			String codeEnvironmentStr = JLFConfig.getValue("codeEnvironment");
			if (codeEnvironmentStr == null || codeEnvironmentStr.length() == 0) {
				throw new Exception("δ���õ�ǰ���뻷��codeEnvironment");
			}
			codeEnvironment = CodeEnvironment.valueOf(codeEnvironmentStr);
			serverJarPath = JLFConfig.getValue("serverJarPath");
			if (serverJarPath == null) {
				throw new Exception("δ���÷����jar��·��serverJarPath");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getConfigFileName
	 * @Description:��ȡjlf�����ļ�����
	 * @return
	 */
	public static String getConfigFileName() {
		return configFileName;
	}

	/**
	 * 
	 * @Title: getConfigPath
	 * @Description:��ȡ�����ļ�·��
	 * @return
	 */
	public static String getConfigPath() {
		return configPath;
	}

	/**
	 * 
	 * @Title: getJAFConfig
	 * @Description:��ȡJAF��������Ϣ
	 * @return
	 */
	public static IniUtil getJLFConfig() {
		return JLFConfig;
	}

	/**
	 * 
	 * @Title: getPluginConfigName
	 * @Description:��ȡĳ������������ļ�·��
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
	 * @Description:��ȡĳ����Ʒ�������ļ�·��
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
	 * @Description:��ȡĳ���ܹ��������ļ�·��
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
	 * @Description:��ȡ��ǰ���뻷��
	 * @return
	 */
	public static CodeEnvironment getCodeEnvironment() {
		return codeEnvironment;
	}

	/**
	 * 
	 * @Title: getServerJarPath
	 * @Description:��ȡ�����jar���Ĵ��·��
	 * @return
	 */
	public static String getServerJarPath() {
		return serverJarPath;
	}
}
