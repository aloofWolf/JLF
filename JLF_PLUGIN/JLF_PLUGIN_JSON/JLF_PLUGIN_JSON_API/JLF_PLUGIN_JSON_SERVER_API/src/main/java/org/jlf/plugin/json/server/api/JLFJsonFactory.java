package org.jlf.plugin.json.server.api;

import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JLFJsonFactory
 * @Description:json����api
 * @author Lone Wolf
 * @date 2019��6��5��
 */
public interface JLFJsonFactory extends JLFIPlugin {

	/**
	 * 
	 * @Title: newJson
	 * @Description:����json����
	 * @return
	 */
	public JLFJson newJson();

	/**
	 * 
	    * @Title: beanToJson
	    * @Description:��bean����תjson
	    * @param bean
	    * @return
	    * @throws Exception
	 */
	public JLFJson beanToJson(Object bean)throws Exception;
	
	/**
	 * 
	    * @Title: beanToJsonStr
	    * @Description:��bean����תjson�ַ���
	    * @param bean
	    * @return
	 * @throws Exception 
	 */
	public String beanToJsonStr(Object bean) throws Exception;

	/**
	 * 
	    * @Title: mapToJson
	    * @Description:��map����תjson
	    * @param map
	    * @return
	    * @throws Exception
	 */
	public JLFJson mapToJson(Map<String, Object> map)throws Exception;
	
	/**
	 * 
	    * @Title: mapToJsonStr
	    * @Description:��map����תjson�ַ���
	    * @param map
	    * @return
	    * @throws Exception
	 */
	public String mapToJsonStr(Map<String, Object> map)throws Exception;

	/**
	 * 
	 * @Title: toJson
	 * @Description:��json�ַ���תjson
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public JLFJson jsonStrToJson(String jsonStr)throws Exception;
	
	/**
	 * 
	 * @Title: jsonStrToBean
	 * @Description:��json�ַ���תbean
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public <T> T jsonStrToBean(String jsonStr,Class<T> beanCls)throws Exception;
	
	/**
	 * 
	 * @Title: toJson
	 * @Description:��json�ַ���תmap
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> jsonStrToMap(String jsonStr)throws Exception;


	/**
	 * 
	 * @Title: newJsonArray
	 * @Description:����json�������
	 * @return
	 * @throws Exception
	 */
	public JLFJsonArray newJsonArray()throws Exception;

}
