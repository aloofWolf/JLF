package org.jlf.plugin.server.core.check.custom.detail;

import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: CustomerCheck
 * @Description:�Զ�������У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class CustomerCheck extends ICheck<JLFJson> {

	@Override
	public JLFJson getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return json.getJson(checkName);
	}

}
