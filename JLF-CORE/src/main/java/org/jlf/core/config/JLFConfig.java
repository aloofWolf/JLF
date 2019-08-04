package org.jlf.core.config;

import org.jlf.common.util.PathUtil;

/**
 * 
 * @ClassName: JLFConfig
 * @Description:JLL����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class JLFConfig {

	private static String configPath; // �����ļ�·��

	/**
	 * ��ʼ����ȡ�������������ļ�
	 */
	static {
		configPath = PathUtil.getConfigFilePath();
	}

	/**
	 * 
	 * @Title: getPluginConfigFilePath
	 * @Description:��ȡĳ������������ļ�·��
	 * @param pluginName
	 * @return
	 */
	public static String getPluginConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("PLUGINS/").append(configFileName).toString();
	}

	/**
	 * 
	 * @Title: getProductConfigFilePath
	 * @Description:��ȡĳ����Ʒ�������ļ�·��
	 * @param pluginName
	 * @return
	 */
	public static String getProductConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("PRODUCTS/").append(configFileName).toString();
	}

	/**
	 * 
	 * @Title: getSoaConfigFilePath
	 * @Description:��ȡĳ���ܹ��������ļ�·��
	 * @param pluginName
	 * @return
	 */
	public static String getSoaConfigFilePath(String configFileName) {
		return new StringBuffer(configPath).append("SOAS/").append(configFileName).toString();
	}
}
