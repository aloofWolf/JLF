package org.jlf.plugin.check.wolf.server.core.detail.collection;

import java.lang.reflect.Field;
import java.util.Map;

import org.jlf.plugin.check.wolf.server.core.detail.CollectionCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: MapCheck
 * @Description:map类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
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