package org.jlf.plugin.server.core.check.custom.detail;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.EnumUtil;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

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
	public IEnum getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		Integer valueInt = json.getInt(checkName);
		if (valueInt == null) {
			return null;
		}
		IEnum value = EnumUtil.getByID((Class<E>) checkCls, valueInt);
		return value;
	}

}
