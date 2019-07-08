package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: DoubleCheck
 * @Description:Double����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class DoubleCheck extends NumberCheck<Double> {

	@Override
	public Double getValue(JLFJson json, Field field) {
		return json.getDouble(field.getName());
	}
}
