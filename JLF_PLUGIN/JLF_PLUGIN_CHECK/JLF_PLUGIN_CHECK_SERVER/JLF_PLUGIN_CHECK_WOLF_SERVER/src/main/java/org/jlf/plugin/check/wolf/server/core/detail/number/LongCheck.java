package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: LongCheck
 * @Description:Long����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class LongCheck extends NumberCheck<Long> {

	@Override
	public Long getValue(JLFJson json, Field field) {
		return json.getLong(field.getName());
	}
}
