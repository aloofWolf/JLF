package org.jlf.plugin.server.core.check.suctom.detail.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jlf.common.util.ClassUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;
import org.jlf.plugin.server.core.check.custom.detail.CollectionCheck;

/**
 * 
 * @ClassName: ListCheck
 * @Description:list����У��
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class ListCheck extends CollectionCheck<List<?>> {

	@Override
	public List<?> getValue(JLFJson json, Field field) {
		Object value = json.get(field.getName());
		if (value == null) {
			return null;
		}
		Class<?> listTCls = GenericityUtil.getFieldGenerCls(field); // ��ȡlist�з��͵�����
		if (ClassUtil.clsIsCustom(listTCls)) {// ���͵�����Ϊ�Զ�������
			JLFJsonArray array = json.getJsonArray(field.getName());
			List<JLFJson> list = new ArrayList<JLFJson>();
			for (int i = 0; i < array.size(); i++) {
				list.add(array.get(i));
			}
			return list;
		} else {// ���͵����Ͳ����Զ�������
			String str = json.getStr(field.getName());
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
