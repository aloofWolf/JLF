package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

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
