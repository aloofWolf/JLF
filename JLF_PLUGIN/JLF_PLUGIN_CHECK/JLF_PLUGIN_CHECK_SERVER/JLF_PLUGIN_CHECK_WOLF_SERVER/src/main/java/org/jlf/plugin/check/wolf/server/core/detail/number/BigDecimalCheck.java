package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: BigDecimalCheck
 * @Description:BigDecimal����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class BigDecimalCheck extends NumberCheck<BigDecimal> {

	@Override
	public BigDecimal getValue(JLFJson json, Field field) {
		return json.getBigDecimal(field.getName());
	}

}
