package org.jlf.plugin.json.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFJsonFactory
 * @Description:json����api
 * @author Lone Wolf
 * @date 2019��6��5��
 */
public interface JLFJsonFactory extends JLFPluginServerApi {

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
	 */
	public JLFJson beanToJson(Object bean);

	/**
	 * 
	 * @Title: beanToJsonStr
	 * @Description:��bean����תjson�ַ���
	 * @param bean
	 * @return
	 */
	public String beanToJsonStr(Object bean);

	/**
	 * 
	 * @Title: mapToJson
	 * @Description:��map����תjson
	 * @param map
	 * @return
	 */
	public JLFJson mapToJson(Map<String, Object> map);

	/**
	 * 
	 * @Title: mapToJsonStr
	 * @Description:��map����תjson�ַ���
	 * @param map
	 * @return
	 */
	public String mapToJsonStr(Map<String, Object> map);

	/**
	 * 
	 * @Title: toJson
	 * @Description:��json�ַ���תjson
	 * @param jsonStr
	 * @return
	 */
	public JLFJson jsonStrToJson(String jsonStr);

	/**
	 * 
	 * @Title: jsonStrToBean
	 * @Description:��json�ַ���תbean
	 * @param jsonStr
	 * @return
	 */
	public <T> T jsonStrToBean(String jsonStr, Class<T> beanCls);

	/**
	 * 
	 * @Title: toJson
	 * @Description:��json�ַ���תmap
	 * @param jsonStr
	 * @return
	 */
	public Map<String, Object> jsonStrToMap(String jsonStr);

	/**
	 * 
	 * @Title: newJsonArray
	 * @Description:����json�������
	 * @return
	 */
	public JLFJsonArray newJsonArray();

}
