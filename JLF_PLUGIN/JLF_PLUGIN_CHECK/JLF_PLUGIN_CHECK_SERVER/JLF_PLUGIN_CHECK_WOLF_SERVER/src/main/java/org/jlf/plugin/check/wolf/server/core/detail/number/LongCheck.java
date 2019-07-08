package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: LongCheck
 * @Description:Long类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class LongCheck extends NumberCheck<Long> {

	@Override
	public Long getValue(JLFJson json, Field field) {
		return json.getLong(field.getName());
	}
}
