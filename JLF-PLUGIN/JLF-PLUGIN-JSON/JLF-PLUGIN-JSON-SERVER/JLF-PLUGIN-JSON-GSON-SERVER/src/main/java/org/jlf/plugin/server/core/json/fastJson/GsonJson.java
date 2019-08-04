package org.jlf.plugin.server.core.json.fastJson;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.jlf.common.util.DateUtil;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 
 * @ClassName: FastJson
 * @Description:FastJson
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class GsonJson implements JLFJson {

	private JsonObject json;

	public GsonJson(JsonObject json) {
		this.json = json;
	}

	@Override
	public String toStr() {
		if (json == null) {
			return null;
		}
		return json.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> toMap() {
		Gson gson = new Gson();
		return gson.fromJson(this.json.toString(), Map.class);
	}

	@Override
	public <T> T toBean(Class<T> beanCls) {
		Gson gson = new Gson();
		return gson.fromJson(this.json.toString(), beanCls);
	}

	@Override
	public void put(String key, Object value) {
		if(value != null){
			this.json.addProperty(key, value.toString());
		}else{
			this.json.addProperty(key, "");
		}
		
	}

	@Override
	public void put(String key, JLFJson json) {
		if(json != null){
			this.json.addProperty(key, ((GsonJson) json).get().toString());
		}else{
			this.json.addProperty(key, "");
		}
	}

	@Override
	public void put(String key, JLFJsonArray array) {
		if(array != null){
			this.json.addProperty(key, ((GsonJsonArray) array).get().toString());
		}else{
			this.json.addProperty(key, "");
		}

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
		return json.get(key).getAsString();
	}

	@Override
	public Byte getByte(String key) {
		return json.get(key).getAsByte();
	}

	@Override
	public Short getShort(String key) {
		return json.get(key).getAsShort();
	}

	@Override
	public Integer getInt(String key) {
		return json.get(key).getAsInt();
	}

	@Override
	public Long getLong(String key) {
		return json.get(key).getAsLong();
	}

	@Override
	public Double getDouble(String key) {
		return json.get(key).getAsDouble();
	}

	@Override
	public Float getFloat(String key) {
		return json.get(key).getAsFloat();
	}

	@Override
	public BigDecimal getBigDecimal(String key) {
		return json.get(key).getAsBigDecimal();
	}

	@Override
	public Boolean getBoolean(String key) {
		return json.get(key).getAsBoolean();
	}

	@Override
	public Date getDate(String key) {
		String str = json.get(key).getAsString();
		return DateUtil.formatDate(str);
	}

	@Override
	public JLFJsonArray getJsonArray(String key) {
		return new GsonJsonArray(json.get(key).getAsJsonArray());
	}

	@Override
	public JLFJson getJson(String key) {
		JsonObject obj = json.get(key).getAsJsonObject();
		return new GsonJson(obj);
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
	protected JsonObject get() {
		return this.json;
	}

}
