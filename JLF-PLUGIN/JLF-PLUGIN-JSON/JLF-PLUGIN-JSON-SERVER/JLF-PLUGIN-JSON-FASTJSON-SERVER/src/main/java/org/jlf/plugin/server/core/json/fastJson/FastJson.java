package org.jlf.plugin.server.core.json.fastJson;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: FastJson
 * @Description:FastJson
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class FastJson implements JLFJson {

	private JSONObject json;

	public FastJson(JSONObject json) {
		this.json = json;
	}

	@Override
	public String toStr() {
		if (json == null) {
			return null;
		}
		return json.toJSONString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> toMap() {
		return JSONObject.toJavaObject(json, Map.class);
	}

	@Override
	public <T> T toBean(Class<T> beanCls) {
		return JSONObject.parseObject(json.toJSONString(), beanCls);
	}

	@Override
	public void put(String key, Object value) {
		this.json.put(key, value);
	}

	@Override
	public void put(String key, JLFJson json) {
		this.json.put(key, ((FastJson) json).get());

	}

	@Override
	public void put(String key, JLFJsonArray array) {
		this.json.put(key, ((FastJsonArray) array).get());

	}

	@Override
	public void remove(String key) {
		this.json.remove(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key) {
		return (T) json.get(key);
	}

	@Override
	public String getStr(String key) {
		return json.getString(key);
	}

	@Override
	public Byte getByte(String key) {
		return json.getByte(key);
	}

	@Override
	public Short getShort(String key) {
		return json.getShort(key);
	}

	@Override
	public Integer getInt(String key) {
		return json.getInteger(key);
	}

	@Override
	public Long getLong(String key) {
		return json.getLong(key);
	}

	@Override
	public Double getDouble(String key) {
		return json.getDouble(key);
	}

	@Override
	public Float getFloat(String key) {
		return json.getFloat(key);
	}

	@Override
	public BigDecimal getBigDecimal(String key) {
		return json.getBigDecimal(key);
	}

	@Override
	public Boolean getBoolean(String key) {
		return json.getBoolean(key);
	}

	@Override
	public Date getDate(String key) {
		return json.getDate(key);
	}

	@Override
	public JLFJsonArray getJsonArray(String key) {
		return new FastJsonArray(json.getJSONArray(key));
	}

	@Override
	public JLFJson getJson(String key) {
		JSONObject obj = json.getJSONObject(key);
		return new FastJson(obj);
	}

	@Override
	public int size() {
		return json.size();
	}

	/**
	 * 
	 * @Title: get
	 * @Description:获取当前json对象
	 * @return @
	 */
	protected JSONObject get() {
		return this.json;
	}

}
