package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: DoubleCheck
 * @Description:Double类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class DoubleCheck extends NumberCheck<Double> {

	@Override
	public Double getValue(JLFJson json, Field field) {
		return json.getDouble(field.getName());
	}
}
