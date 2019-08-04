package org.jlf.plugin.server.core.json.fastJson;

import java.util.Map;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @ClassName: FastJsonFactory
 * @Description:FastJsonFactory
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class GsonJsonFactory implements JLFJsonFactory {

	@Override
	public JLFJson newJson() {
		return new GsonJson(new JsonObject());
	}

	@Override
	public JLFJson beanToJson(Object bean) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(bean);
		return new GsonJson(new JsonParser().parse(jsonStr).getAsJsonObject());
	}

	@Override
	public String beanToJsonStr(Object bean) {
		Gson gson = new Gson();
		return gson.toJson(bean);
	}

	@Override
	public JLFJson mapToJson(Map<String, Object> map) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		return new GsonJson(new JsonParser().parse(jsonStr).getAsJsonObject());
	}

	@Override
	public String mapToJsonStr(Map<String, Object> map) {
		Gson gson = new Gson();
		return gson.toJson(map);
	}

	@Override
	public JLFJson jsonStrToJson(String jsonStr) {
		return new GsonJson(new JsonParser().parse(jsonStr).getAsJsonObject());
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
		JsonArray array = new JsonArray();
		return new GsonJsonArray(array);
	}

}
