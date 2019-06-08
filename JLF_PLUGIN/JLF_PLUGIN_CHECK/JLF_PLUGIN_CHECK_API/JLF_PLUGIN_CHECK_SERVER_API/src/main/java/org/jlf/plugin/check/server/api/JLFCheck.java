package org.jlf.plugin.check.server.api;

import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
    * @ClassName: JLFCheck
    * @Description:checkApi
    * @author Lone Wolf
    * @date 2019年5月22日
 */
public interface JLFCheck extends JLFIPlugin {

	/**
	 * 
	 * @Title: check
	 * @Description:对json字符串进行校验
	 * @param jsonStr
	 * @param cls
	 * @return
	 * @throws Exception 
	 */
	public <T> T check(String jsonStr, Class<T> cls) throws Exception;

	/**
	 * 
	 * @Title: check
	 * @Description:对map进行校验
	 * @param map
	 * @param cls
	 * @return
	 * @throws Exception 
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls) throws Exception;
}
