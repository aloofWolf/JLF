package org.jlf.plugin.check.server.api;

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

	/**
	 * 
	 * @Title: check
	 * @Description:��json�ַ�������У��
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public <T> T check(String jsonStr, Class<T> cls);

	/**
	 * 
	 * @Title: check
	 * @Description:��map����У��
	 * @param map
	 * @param cls
	 * @return
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls);
}
