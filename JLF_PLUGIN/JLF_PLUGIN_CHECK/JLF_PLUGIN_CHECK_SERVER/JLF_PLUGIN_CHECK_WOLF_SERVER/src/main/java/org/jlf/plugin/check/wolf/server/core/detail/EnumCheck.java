package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: EnumCheck
 * @Description:枚举类型校验
 * @author Lone Wolf
 * @date 2019年5月31日
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
