package org.jlf.plugin.check.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFCheck
 * @Description:checkApi
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public interface JLFCheck extends JLFPluginServerApi {

	/**
	 * 
	 * @Title: check
	 * @Description:对json字符串进行校验
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public <T> T check(String jsonStr, Class<T> cls);

	/**
	 * 
	 * @Title: check
	 * @Description:对map进行校验
	 * @param map
	 * @param cls
	 * @return
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls);
}
