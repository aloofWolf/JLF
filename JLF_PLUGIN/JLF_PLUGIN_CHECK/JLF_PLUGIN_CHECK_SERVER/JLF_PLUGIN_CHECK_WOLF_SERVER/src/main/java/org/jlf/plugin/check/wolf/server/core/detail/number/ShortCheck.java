package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: ShortCheck
 * @Description:Short����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class ShortCheck extends NumberCheck<Short> {

	@Override
	public Short getValue(JLFJson json, Field field) throws Exception {
		return json.getShort(field.getName());
	}
}
