package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

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
