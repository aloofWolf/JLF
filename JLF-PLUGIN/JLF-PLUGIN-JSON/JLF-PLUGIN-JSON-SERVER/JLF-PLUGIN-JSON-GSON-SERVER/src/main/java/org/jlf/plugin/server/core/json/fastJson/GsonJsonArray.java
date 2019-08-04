package org.jlf.plugin.server.core.json.fastJson;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

import com.google.gson.JsonArray;

/**
 * 
 * @ClassName: FastJsonArray
 * @Description:FastJsonArray
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class GsonJsonArray implements JLFJsonArray {

	private JsonArray array;

	protected GsonJsonArray(JsonArray array) {
		this.array = array;
	}

	@Override
	public int size() {
		return this.array.size();
	}

	@Override
	public void add(JLFJson json) {
		this.array.add(((GsonJson) json).get());

	}

	@Override
	public void remove(JLFJson json) {
		this.array.remove(((GsonJson) json).get());

	}

	@Override
	public JLFJson get(int index) {
		return new GsonJson(this.array.get(index).getAsJsonObject());
	}

	@Override
	public JLFJsonArray getJsonArray(int index) {
		return new GsonJsonArray(this.array.get(index).getAsJsonArray());
	}

	/**
	 * 
	 * @Title: get
	 * @Description:获取当前jsonArray对象
	 * @return @
	 */
	protected JsonArray get() {
		return this.array;
	}

}
