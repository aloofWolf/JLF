package org.jlf.plugin.json.server.api;

import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JLFJsonFactory
 * @Description:json工厂api
 * @author Lone Wolf
 * @date 2019年6月5日
 */
public interface JLFJsonFactory extends JLFIPlugin {

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
	    * @throws Exception
	 */
	public JLFJson beanToJson(Object bean)throws Exception;
	
	/**
	 * 
	    * @Title: beanToJsonStr
	    * @Description:将bean对象转json字符串
	    * @param bean
	    * @return
	 * @throws Exception 
	 */
	public String beanToJsonStr(Object bean) throws Exception;

	/**
	 * 
	    * @Title: mapToJson
	    * @Description:将map对象转json
	    * @param map
	    * @return
	    * @throws Exception
	 */
	public JLFJson mapToJson(Map<String, Object> map)throws Exception;
	
	/**
	 * 
	    * @Title: mapToJsonStr
	    * @Description:将map对象转json字符串
	    * @param map
	    * @return
	    * @throws Exception
	 */
	public String mapToJsonStr(Map<String, Object> map)throws Exception;

	/**
	 * 
	 * @Title: toJson
	 * @Description:将json字符串转json
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public JLFJson jsonStrToJson(String jsonStr)throws Exception;
	
	/**
	 * 
	 * @Title: jsonStrToBean
	 * @Description:将json字符串转bean
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public <T> T jsonStrToBean(String jsonStr,Class<T> beanCls)throws Exception;
	
	/**
	 * 
	 * @Title: toJson
	 * @Description:将json字符串转map
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> jsonStrToMap(String jsonStr)throws Exception;


	/**
	 * 
	 * @Title: newJsonArray
	 * @Description:创建json数组对象
	 * @return
	 * @throws Exception
	 */
	public JLFJsonArray newJsonArray()throws Exception;

}
