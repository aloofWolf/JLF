package org.jlf.core.config;

import java.util.Properties;

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

	private static String configFilePath = PathUtil.getRootPath(); // �����ļ�·��
	private static String configFileName = "JLF.ini"; // �����ļ���

	private static IniUtil jLFConfig; // ��Ŀ����

	private static final String pluginConfigName = "plugin-%s";
	private static final String productConfigName = "product-%s";
	private static final String soaConfigName = "soa-%s";

	static {
		loadConfig();
	}

	/**
	 * 
	 * @Title: loadConfig
	 * @Description: ��������
	 */
	private static void loadConfig() {
		jLFConfig = new IniUtil(new StringBuffer(configFilePath).append(configFileName).toString());
	}

	/**
	 * 
	 * @Title: getPluginConfig
	 * @Description:��ȡĳ�����������,�������¼��������ļ�
	 * @param pluginName
	 * @return
	 */
	public static Properties getPluginConfig(String pluginName) {
		return getPluginConfig(pluginName, false);
	}

	/**
	 * 
	 * @Title: getPluginConfig
	 * @Description: ��ȡĳ�����������
	 * @param pluginName
	 * @param reLoadConfig
	 *            �Ƿ���Ҫ���¼��������ļ�
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
	 * @Description:��ȡĳ����Ʒ������,�������¼��������ļ�
	 * @param productName
	 * @return
	 */
	public static Properties getProductConfig(String productName) {
		return getProductConfig(productName, false);
	}

	/**
	 * 
	 * @Title: getProductConfig
	 * @Description: ��ȡĳ����Ʒ������
	 * @param productName
	 * @param reLoadConfig
	 *            �Ƿ���Ҫ���¼��������ļ�
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
	 * @Description:��ȡĳ���ܹ�������,�������¼��������ļ�
	 * @param pluginName
	 * @return
	 */
	public static Properties getSoaConfig(String soaName) {
		return getSoaConfig(soaName, false);
	}

	/**
	 * 
	 * @Title: getSoaConfig
	 * @Description:��ȡĳ���ܹ�������
	 * @param soaName
	 * @param reLoadConfig
	 *            �Ƿ���Ҫ���¼��������ļ�
	 * @return
	 */
	public static Properties getSoaConfig(String soaName, boolean reLoadConfig) {
		if (reLoadConfig) {
			loadConfig();
		}
		return jLFConfig.getSection(String.format(soaConfigName, soaName));
	}
}
