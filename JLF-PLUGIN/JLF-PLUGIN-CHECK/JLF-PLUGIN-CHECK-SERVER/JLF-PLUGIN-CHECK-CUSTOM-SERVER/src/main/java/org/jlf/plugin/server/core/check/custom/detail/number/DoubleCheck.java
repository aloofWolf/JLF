package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

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
