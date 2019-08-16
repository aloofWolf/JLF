package org.jlf.plugin.check.server.api;

import java.lang.reflect.Method;
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

	public static final String PLUGIN_NAME = "check";

	/**
	 * 
	 * @Title: check
	 * @Description:对json字符串进行校验,校验cls里的所有field
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public <T> T check(String jsonStr, Class<T> cls);

	/**
	 * 
	 * @Title: check
	 * @Description:对map进行校验,校验cls里的所有field
	 * @param map
	 * @param cls
	 * @return
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls);
	
	/**
	 * 
	 * @Title: check
	 * @Description:对json字符串进行校验,检验method里的所有parameter
	 * @param jsonStr
	 * @param method
	 * @return
	 */
	public Object[] check(String jsonStr, Method method);

	/**
	 * 
	 * @Title: check
	 * @Description:对map进行校验,检验method里的所有parameter
	 * @param map
	 * @param method
	 * @return
	 */
	public Object[] check(Map<String, Object> map, Method method);
}
