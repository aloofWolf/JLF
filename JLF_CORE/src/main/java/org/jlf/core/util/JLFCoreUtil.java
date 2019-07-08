package org.jlf.core.util;

import org.jlf.common.exception.JLFException;
import org.jlf.core.config.JLFConfig;

/**
 * 
 * @ClassName: JLFCoreUtil
 * @Description:JLFCore������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class JLFCoreUtil {

	/**
	 * 
	 * @Title: getServerJarPath
	 * @Description:���ݿͻ��˱�ŷ���˱�Ż�ȡplugin�����jar��·��+����,δָ��jar��·��
	 * @param clientCode
	 * @param serverCode
	 * @return
	 */
	public static String getPluginServerJarPath(String clientCode, String serverCode) {
		return getPluginServerJarPath(clientCode, serverCode, JLFConfig.getServerJarPath());
	}

	/**
	 * 
	 * @Title: getProductServerJarPath
	 * @Description:���ݿͻ��˱�ŷ���˱�Ż�ȡproduct�����jar��·��+����,δָ��jar��·��
	 * @param clientCode
	 * @param serverCode
	 * @return
	 */
	public static String getProductServerJarPath(String clientCode, String serverCode) {
		return getProductServerJarPath(clientCode, serverCode, JLFConfig.getServerJarPath());
	}

	/**
	 * 
	 * @Title: getPluginServerJarPath
	 * @Description:���ݿͻ��˱�ŷ���˱�Ż�ȡplugin�����jar��·��+����,ָ��jar��·��
	 * @param clientCode
	 * @param serverCode
	 * @param serverJarPath
	 * @return
	 */
	public static String getPluginServerJarPath(String clientCode, String serverCode, String serverJarPath) {
		return getServerJarPath("PLUGIN", clientCode, serverCode, serverJarPath);
	}

	/**
	 * 
	 * @Title: getProductServerJarPath
	 * @Description:���ݿͻ��˱�ŷ���˱�Ż�ȡproduct�����jar��·��+����,ָ��jar��·��
	 * @param clientCode
	 * @param serverCode
	 * @param serverJarPath
	 * @return
	 */
	public static String getProductServerJarPath(String clientCode, String serverCode, String serverJarPath) {
		return getServerJarPath("PRODUCT", clientCode, serverCode, serverJarPath);
	}

	/**
	 * 
	 * @Title: getServerJarPath
	 * @Description:���ݿͻ��˱�ŷ���˱�Ż�ȡ�����jar��·��+����,ָ��jar��·��
	 * @param clientCode
	 * @param serverCode
	 * @param serverJarPath
	 * @return
	 */
	private static String getServerJarPath(String module, String clientCode, String serverCode, String serverJarPath) {
		String version = null;
		String[] arr = serverCode.split("-");
		if (arr.length == 1) {
			version = "0.0.1";
		} else if (arr.length == 2) {
			serverCode = arr[0];
			version = arr[1];
		} else {
			throw new JLFException("����˱�Ÿ�ʽ����ȷ:" + serverCode);
		}
		return new StringBuffer("jar:file:/").append(serverJarPath).append("/JLF_").append(module).append("_")
				.append(clientCode.toUpperCase()).append("_").append(serverCode.toUpperCase()).append("_SERVER-")
				.append(version).append(".jar!/").toString();
	}
}
