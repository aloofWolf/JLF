package org.jlf.plugin.server.core.check.custom.detail.number;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: DoubleCheck
 * @Description:Double����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class DoubleCheck extends NumberCheck<Double> {

	@Override
	public Double getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getDouble(checkName);
	}
}
