package org.jlf.plugin.check.wolf.server.core.detail.number;

import java.lang.reflect.Field;

import org.jlf.plugin.check.wolf.server.core.detail.NumberCheck;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: ByteCheck
 * @Description:Byte����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class ByteCheck extends NumberCheck<Byte> {

	@Override
	public Byte getValue(JLFJson json, Field field) throws Exception {
		return json.getByte(field.getName());
	}
}
