package org.jlf.plugin.server.core.check.custom.detail.number;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;

/**
 * 
 * @ClassName: BigDecimalCheck
 * @Description:BigDecimal类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class BigDecimalCheck extends NumberCheck<BigDecimal> {

	@Override
	public BigDecimal getValue(JLFJson json, Field field) {
		return json.getBigDecimal(field.getName());
	}

}
