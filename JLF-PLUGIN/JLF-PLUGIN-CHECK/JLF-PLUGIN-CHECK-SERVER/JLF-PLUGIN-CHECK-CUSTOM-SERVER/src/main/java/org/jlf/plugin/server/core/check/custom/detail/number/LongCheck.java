package org.jlf.plugin.server.core.check.custom.detail.number;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.detail.NumberCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: LongCheck
 * @Description:Long类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class LongCheck extends NumberCheck<Long> {

	@Override
	public Long getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getLong(checkName);
	}
}
