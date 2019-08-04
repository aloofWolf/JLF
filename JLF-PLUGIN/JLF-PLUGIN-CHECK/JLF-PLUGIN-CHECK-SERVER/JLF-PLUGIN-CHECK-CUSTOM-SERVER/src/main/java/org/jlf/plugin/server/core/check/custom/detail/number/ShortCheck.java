package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: ShortCheck
 * @Description:Short类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class ShortCheck extends NumberCheck<Short> {

	@Override
	public Short getValue(JLFJson json, Field field) {
		return json.getShort(field.getName());
	}
}
