package org.jlf.plugin.json.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFJsonFactory
 * @Description:json工厂api
 * @author Lone Wolf
 * @date 2019年6月5日
 */
public interface JLFJsonFactory extends JLFPluginServerApi {

	/**
	 * 
	 * @Title: newJson
	 * @Description:创建json对象
	 * @return
	 */
	public JLFJson newJson();

	/**
	 * 
	 * @Title: beanToJson
	 * @Description:将bean对象转json
	 * @param bean
	 * @return
	 */
	public JLFJson beanToJson(Object bean);

	/**
	 * 
	 * @Title: beanToJsonStr
	 * @Description:将bean对象转json字符串
	 * @param bean
	 * @return
	 */
	public String beanToJsonStr(Object bean);

	/**
	 * 
	 * @Title: mapToJson
	 * @Description:将map对象转json
	 * @param map
	 * @return
	 */
	public JLFJson mapToJson(Map<String, Object> map);

	/**
	 * 
	 * @Title: mapToJsonStr
	 * @Description:将map对象转json字符串
	 * @param map
	 * @return
	 */
	public String mapToJsonStr(Map<String, Object> map);

	/**
	 * 
	 * @Title: toJson
	 * @Description:将json字符串转json
	 * @param jsonStr
	 * @return
	 */
	public JLFJson jsonStrToJson(String jsonStr);

	/**
	 * 
	 * @Title: jsonStrToBean
	 * @Description:将json字符串转bean
	 * @param jsonStr
	 * @return
	 */
	public <T> T jsonStrToBean(String jsonStr, Class<T> beanCls);

	/**
	 * 
	 * @Title: toJson
	 * @Description:将json字符串转map
	 * @param jsonStr
	 * @return
	 */
	public Map<String, Object> jsonStrToMap(String jsonStr);

	/**
	 * 
	 * @Title: newJsonArray
	 * @Description:创建json数组对象
	 * @return
	 */
	public JLFJsonArray newJsonArray();

}
