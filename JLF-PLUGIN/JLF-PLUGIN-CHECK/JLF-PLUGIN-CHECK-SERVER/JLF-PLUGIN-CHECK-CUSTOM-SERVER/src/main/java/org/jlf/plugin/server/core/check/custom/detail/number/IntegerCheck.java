package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: IntegerCheck
 * @Description:Integer����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class IntegerCheck extends NumberCheck<Integer> {

	@Override
	public Integer getValue(JLFJson json, Field field) {
		return json.getInt(field.getName());
	}

}
