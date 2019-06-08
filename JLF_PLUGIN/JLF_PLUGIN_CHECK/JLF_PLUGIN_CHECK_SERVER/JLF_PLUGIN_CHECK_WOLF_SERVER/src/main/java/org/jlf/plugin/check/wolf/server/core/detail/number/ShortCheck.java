package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: ShortCheck
 * @Description:Short类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class ShortCheck extends NumberCheck<Short> {

	@Override
	public Short getValue(JLFJson json, Field field) throws Exception {
		return json.getShort(field.getName());
	}
}
