package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: CustomerCheck
 * @Description:�Զ�������У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class CustomerCheck extends ICheck<JLFJson> {

	@Override
	public JLFJson getValue(JLFJson json, Field field){
		return json.getJson(field.getName());
	}

}
