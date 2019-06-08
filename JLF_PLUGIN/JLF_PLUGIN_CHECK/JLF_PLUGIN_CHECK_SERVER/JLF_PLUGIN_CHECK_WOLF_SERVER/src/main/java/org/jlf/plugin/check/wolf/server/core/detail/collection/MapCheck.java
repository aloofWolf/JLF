package org.jlf.plugin.check.wolf.server.core.detail.collection;

import java.lang.reflect.Field;
import java.util.Map;

import org.jlf.plugin.check.wolf.server.core.detail.CollectionCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: MapCheck
 * @Description:map����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class MapCheck extends CollectionCheck<Map<String, Object>> {

	@Override
	public Map<String, Object> getValue(JLFJson json, Field field) throws Exception {
		JLFJson jsonValue = json.getJson(field.getName());
		Map<String, Object> map = jsonValue.toMap();
		return map;
	}

	@Override
	protected int getSize(Map<String, Object> value) {
		return value.size();
	}
}