package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: IntegerCheck
 * @Description:Integer类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class IntegerCheck extends NumberCheck<Integer> {

	@Override
	public Integer getValue(JLFJson json, Field field) {
		return json.getInt(field.getName());
	}

}
