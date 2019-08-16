package org.jlf.plugin.server.core.check.custom.detail.number;

import java.math.BigDecimal;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: BigDecimalCheck
 * @Description:BigDecimal类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class BigDecimalCheck extends NumberCheck<BigDecimal> {

	@Override
	public BigDecimal getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getBigDecimal(checkName);
	}

}
