package org.jlf.plugin.json.fastjson.server.core;

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
	public Map<String, Object> toMap() throws Exception {
		return JSONObject.toJavaObject(json, Map.class);
	}

	@Override
	public <T> T toBean(Class<T> beanCls) throws Exception {
		return JSONObject.parseObject(json.toJSONString(), beanCls);
	}

	@Override
	public void put(String key, Object value) throws Exception {
		this.json.put(key, value);
	}

	@Override
	public void put(String key, JLFJson json) throws Exception {
		this.json.put(key, ((FastJson) json).get());

	}

	@Override
	public void put(String key, JLFJsonArray array) throws Exception {
		this.json.put(key, ((FastJsonArray) array).get());

	}

	@Override
	public void remove(String key) throws Exception {
		this.json.remove(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key) throws Exception {
		return (T) json.get(key);
	}

	@Override
	public String getStr(String key) throws Exception {
		return json.getString(key);
	}

	@Override
	public Byte getByte(String key) throws Exception {
		return json.getByte(key);
	}

	@Override
	public Short getShort(String key) throws Exception {
		return json.getShort(key);
	}

	@Override
	public Integer getInt(String key) throws Exception {
		return json.getInteger(key);
	}

	@Override
	public Long getLong(String key) throws Exception {
		return json.getLong(key);
	}

	@Override
	public Double getDouble(String key) throws Exception {
		return json.getDouble(key);
	}

	@Override
	public Float getFloat(String key) throws Exception {
		return json.getFloat(key);
	}

	@Override
	public BigDecimal getBigDecimal(String key) throws Exception {
		return json.getBigDecimal(key);
	}

	@Override
	public Boolean getBoolean(String key) throws Exception {
		return json.getBoolean(key);
	}

	@Override
	public Date getDate(String key) throws Exception {
		return json.getDate(key);
	}

	@Override
	public JLFJsonArray getJsonArray(String key) throws Exception {
		return new FastJsonArray(json.getJSONArray(key));
	}

	@Override
	public JLFJson getJson(String key) throws Exception {
		JSONObject obj = json.getJSONObject(key);
		return new FastJson(obj);
	}

	@Override
	public int size() throws Exception {
		return json.size();
	}

	/**
	 * 
	 * @Title: get
	 * @Description:获取当前json对象
	 * @return
	 * @throws Exception
	 */
	protected JSONObject get() throws Exception {
		return this.json;
	}

}
