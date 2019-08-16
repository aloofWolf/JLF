package org.jlf.plugin.server.core.check.custom.detail.number;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: IntegerCheck
 * @Description:Integer类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class IntegerCheck extends NumberCheck<Integer> {

	@Override
	public Integer getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getInt(checkName);
	}

}
