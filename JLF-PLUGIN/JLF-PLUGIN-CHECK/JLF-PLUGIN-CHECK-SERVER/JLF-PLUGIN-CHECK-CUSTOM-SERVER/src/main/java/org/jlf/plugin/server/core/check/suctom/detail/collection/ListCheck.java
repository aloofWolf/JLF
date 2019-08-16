package org.jlf.plugin.server.core.check.suctom.detail.collection;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jlf.common.util.ClassUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;
import org.jlf.plugin.server.core.check.custom.detail.CollectionCheck;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: ListCheck
 * @Description:list类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class ListCheck extends CollectionCheck<List<?>> {

	@Override
	public List<?> getValue(JLFJson json, Object checkObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		Object value = json.get(checkName);
		if (value == null) {
			return null;
		}
		Class<?> listTCls = null;  //获取list中泛型的类型
		if(type.equals(JLFCheckType.FIELD)){
			listTCls = GenericityUtil.getFieldGenerCls((Field) checkObj);
		}else{
			listTCls = GenericityUtil.getParameterGenerCls((Parameter) checkObj);
		}
		if (ClassUtil.clsIsCustom(listTCls)) {// 泛型的类型为自定义类型
			JLFJsonArray array = json.getJsonArray(checkName);
			List<JLFJson> list = new ArrayList<JLFJson>();
			for (int i = 0; i < array.size(); i++) {
				list.add(array.get(i));
			}
			return list;
		} else {// 泛型的类型不是自定义类型
			String str = json.getStr(checkName);
			String[] arr = str.split(",");
			List<?> list = Arrays.asList(arr);
			return list;
		}
	}

	@Override
	protected int getSize(List<?> list) {
		return list.size();
	}
}
