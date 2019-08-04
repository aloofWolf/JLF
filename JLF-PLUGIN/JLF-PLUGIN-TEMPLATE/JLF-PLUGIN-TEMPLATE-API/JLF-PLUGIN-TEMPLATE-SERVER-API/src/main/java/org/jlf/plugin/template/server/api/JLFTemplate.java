package org.jlf.plugin.template.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFTemplate
 * @Description:JLFTemplateApi
 * @author Lone Wolf
 * @date 2019��7��2��
 */
public interface JLFTemplate extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "template";

	/**
	 * 
	 * @Title: getStringFromJar
	 * @Description:����ģ���ļ������ַ���,ģ���ļ���jar�л�ȡ
	 * @param templateFilePath
	 * @param map
	 * @param contextName
	 * @param jarPath
	 * @return
	 */
	public String getStringFromJar(String templateFilePath, Map<String, Object> map, String contextName,
			String jarPath);

	/**
	 * 
	 * @Title: getStringFromJar
	 * @Description:����ģ���ļ������ַ���,ģ���ļ���jar�л�ȡ
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @param jarPath
	 * @return
	 */
	public String getStringFromJar(String templateFilePath, Object obj, String contextName, String jarPath);

	/**
	 * 
	 * @Title: getStringFromClassPath
	 * @Description:����ģ���ļ������ַ���,ģ���ļ���classPath�л�ȡ
	 * @param templateFilePath
	 * @param map
	 * @param contextName
	 * @return
	 */
	public String getStringFromClassPath(String templateFilePath, Map<String, Object> map, String contextName);

	/**
	 * 
	 * @Title: getStringFromClassPath
	 * @Description:����ģ���ļ������ַ���,ģ���ļ���classPath�л�ȡ
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @return
	 */
	public String getStringFromClassPath(String templateFilePath, Object obj, String contextName);

	/**
	 * 
	 * @Title: getStringFromAbsolutePath
	 * @Description:����ģ���ļ������ַ���,ģ���ļ��Ӿ���·���л�ȡ
	 * @param templateFilePath
	 * @param map
	 * @param contextName
	 * @return
	 */
	public String getStringFromAbsolutePath(String templateFilePath, Map<String, Object> map, String contextName);

	/**
	 * 
	 * @Title: getStringFromAbsolutePath
	 * @Description:����ģ���ļ������ַ���,ģ���ļ��Ӿ���·���л�ȡ
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @return
	 */
	public String getStringFromAbsolutePath(String templateFilePath, Object obj, String contextName);

}
