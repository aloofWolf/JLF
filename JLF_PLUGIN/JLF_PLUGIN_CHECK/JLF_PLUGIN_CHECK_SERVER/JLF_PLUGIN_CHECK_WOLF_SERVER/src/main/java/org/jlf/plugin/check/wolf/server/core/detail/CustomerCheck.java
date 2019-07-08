package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: CustomerCheck
 * @Description:自定义类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CustomerCheck extends ICheck<JLFJson> {

	@Override
	public JLFJson getValue(JLFJson json, Field field){
		return json.getJson(field.getName());
	}

}
