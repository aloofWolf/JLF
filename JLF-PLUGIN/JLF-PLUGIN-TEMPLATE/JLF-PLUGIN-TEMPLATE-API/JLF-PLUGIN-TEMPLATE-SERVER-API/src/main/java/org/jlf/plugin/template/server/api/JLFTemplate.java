package org.jlf.plugin.template.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFTemplate
 * @Description:JLFTemplateApi
 * @author Lone Wolf
 * @date 2019年7月2日
 */
public interface JLFTemplate extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "template";

	/**
	 * 
	 * @Title: getStringFromJar
	 * @Description:根据模板文件生成字符串,模板文件从jar中获取
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
	 * @Description:根据模板文件生成字符串,模板文件从jar中获取
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
	 * @Description:根据模板文件生成字符串,模板文件从classPath中获取
	 * @param templateFilePath
	 * @param map
	 * @param contextName
	 * @return
	 */
	public String getStringFromClassPath(String templateFilePath, Map<String, Object> map, String contextName);

	/**
	 * 
	 * @Title: getStringFromClassPath
	 * @Description:根据模板文件生成字符串,模板文件从classPath中获取
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @return
	 */
	public String getStringFromClassPath(String templateFilePath, Object obj, String contextName);

	/**
	 * 
	 * @Title: getStringFromAbsolutePath
	 * @Description:根据模板文件生成字符串,模板文件从绝对路径中获取
	 * @param templateFilePath
	 * @param map
	 * @param contextName
	 * @return
	 */
	public String getStringFromAbsolutePath(String templateFilePath, Map<String, Object> map, String contextName);

	/**
	 * 
	 * @Title: getStringFromAbsolutePath
	 * @Description:根据模板文件生成字符串,模板文件从绝对路径中获取
	 * @param templateFilePath
	 * @param obj
	 * @param contextName
	 * @return
	 */
	public String getStringFromAbsolutePath(String templateFilePath, Object obj, String contextName);

}
