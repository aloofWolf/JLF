package org.jlf.plugin.server.core.check.custom.detail;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: CustomerCheck
 * @Description:自定义类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CustomerCheck extends ICheck<JLFJson> {

	@Override
	public JLFJson getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getJson(checkName);
	}

}
