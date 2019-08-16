package org.jlf.plugin.check.server.api;

import java.lang.reflect.Method;
import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFCheck
 * @Description:checkApi
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public interface JLFCheck extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "check";

	/**
	 * 
	 * @Title: check
	 * @Description:��json�ַ�������У��,У��cls�������field
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public <T> T check(String jsonStr, Class<T> cls);

	/**
	 * 
	 * @Title: check
	 * @Description:��map����У��,У��cls�������field
	 * @param map
	 * @param cls
	 * @return
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls);
	
	/**
	 * 
	 * @Title: check
	 * @Description:��json�ַ�������У��,����method�������parameter
	 * @param jsonStr
	 * @param method
	 * @return
	 */
	public Object[] check(String jsonStr, Method method);

	/**
	 * 
	 * @Title: check
	 * @Description:��map����У��,����method�������parameter
	 * @param map
	 * @param method
	 * @return
	 */
	public Object[] check(Map<String, Object> map, Method method);
}
