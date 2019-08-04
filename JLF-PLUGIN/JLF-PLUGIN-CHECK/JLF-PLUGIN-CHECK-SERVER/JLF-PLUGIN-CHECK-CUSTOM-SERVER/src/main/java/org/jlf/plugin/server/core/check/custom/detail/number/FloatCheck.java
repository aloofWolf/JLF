package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: FloatCheck
 * @Description:Float����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class FloatCheck extends NumberCheck<Float> {

	@Override
	public Float getValue(JLFJson json, Field field) {
		return json.getFloat(field.getName());
	}
}
