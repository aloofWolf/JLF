package org.jlf.plugin.check.server.api;

import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
    * @ClassName: JLFCheck
    * @Description:checkApi
    * @author Lone Wolf
    * @date 2019��5��22��
 */
public interface JLFCheck extends JLFIPlugin {

	/**
	 * 
	 * @Title: check
	 * @Description:��json�ַ�������У��
	 * @param jsonStr
	 * @param cls
	 * @return
	 * @throws Exception 
	 */
	public <T> T check(String jsonStr, Class<T> cls) throws Exception;

	/**
	 * 
	 * @Title: check
	 * @Description:��map����У��
	 * @param map
	 * @param cls
	 * @return
	 * @throws Exception 
	 */
	public <T> T check(Map<String, Object> map, Class<T> cls) throws Exception;
}
