package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: ShortCheck
 * @Description:Short����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class ShortCheck extends NumberCheck<Short> {

	@Override
	public Short getValue(JLFJson json, Field field) {
		return json.getShort(field.getName());
	}
}
