package org.jlf.plugin.server.core.json.fastJson;

import java.util.Map;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: FastJsonFactory
 * @Description:FastJsonFactory
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class FastJsonFactory implements JLFJsonFactory {

	@Override
	public JLFJson newJson() {
		JSONObject json = new JSONObject();
		return new FastJson(json);
	}

	@Override
	public JLFJson beanToJson(Object bean) {
		return new FastJson((JSONObject) JSONObject.toJSON(bean));
	}

	@Override
	public String beanToJsonStr(Object bean) {
		JLFJson json = beanToJson(bean);
		return json.toStr();
	}

	@Override
	public JLFJson mapToJson(Map<String, Object> map) {
		JSONObject json = new JSONObject(map);
		return new FastJson(json);
	}

	@Override
	public String mapToJsonStr(Map<String, Object> map) {
		JLFJson json = mapToJson(map);
		return json.toStr();
	}

	@Override
	public JLFJson jsonStrToJson(String jsonStr) {
		JSONObject json = JSONObject.parseObject(jsonStr);
		return new FastJson(json);
	}

	@Override
	public <T> T jsonStrToBean(String jsonStr, Class<T> beanCls) {
		JLFJson json = jsonStrToJson(jsonStr);
		return json.toBean(beanCls);
	}

	@Override
	public Map<String, Object> jsonStrToMap(String jsonStr) {
		JLFJson json = jsonStrToJson(jsonStr);
		return json.toMap();
	}

	@Override
	public JLFJsonArray newJsonArray() {
		JSONArray array = new JSONArray();
		return new FastJsonArray(array);
	}

}
