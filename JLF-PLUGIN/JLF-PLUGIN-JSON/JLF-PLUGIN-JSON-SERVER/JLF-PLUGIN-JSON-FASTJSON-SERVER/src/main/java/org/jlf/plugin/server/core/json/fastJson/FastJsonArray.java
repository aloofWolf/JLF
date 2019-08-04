package org.jlf.plugin.server.core.json.fastJson;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @ClassName: FastJsonArray
 * @Description:FastJsonArray
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class FastJsonArray implements JLFJsonArray {

	private JSONArray array;

	protected FastJsonArray(JSONArray array) {
		this.array = array;
	}

	@Override
	public int size() {
		return this.array.size();
	}

	@Override
	public void add(JLFJson json) {
		this.array.add(((FastJson) json).get());

	}

	@Override
	public void remove(JLFJson json) {
		this.array.remove(json);

	}

	@Override
	public JLFJson get(int index) {
		return new FastJson(this.array.getJSONObject(index));
	}

	@Override
	public JLFJsonArray getJsonArray(int index) {
		return new FastJsonArray(this.array.getJSONArray(index));
	}

	/**
	 * 
	 * @Title: get
	 * @Description:获取当前jsonArray对象
	 * @return @
	 */
	protected JSONArray get() {
		return this.array;
	}

}
