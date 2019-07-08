package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: EnumCheck
 * @Description:ö������У��
 * @author Lone Wolf
 * @date 2019��5��31��
 * @param <E>
 */
public class EnumCheck<E extends IEnum> extends ICheck<IEnum> {

	@SuppressWarnings("unchecked")
	@Override
	public IEnum getValue(JLFJson json, Field field) {
		Integer valueInt = json.getInt(field.getName());
		if (valueInt == null) {
			return null;
		}
		IEnum value = EnumUtil.getByID((Class<E>) field.getType(), valueInt);
		return value;
	}

}
