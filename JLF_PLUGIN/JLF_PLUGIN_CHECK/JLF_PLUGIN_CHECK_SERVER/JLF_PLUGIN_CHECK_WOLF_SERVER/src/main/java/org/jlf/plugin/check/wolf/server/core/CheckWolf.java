package org.jlf.plugin.check.wolf.server.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.exception.JLFException;
import org.jlf.common.util.ClassUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.check.wolf.server.core.bean.CheckBean;
import org.jlf.plugin.check.wolf.server.core.detail.fac.CheckBeanFactory;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: CheckWolf
 * @Description:CheckWolf核心
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CheckWolf implements JLFCheck {

	@Override
	public <T> T check(String jsonStr, Class<T> cls)  {
		JLFJson json = JLFJsonClient.get().jsonStrToJson(jsonStr);
		return check(json, cls);
	}

	@Override
	public <T> T check(Map<String, Object> map, Class<T> cls)  {
		JLFJson json = JLFJsonClient.get().mapToJson(map);
		return check(json, cls);
	}

	/**
	 * 
	 * @Title: check
	 * @Description:对JSONObject进行check
	 * @param json
	 * @param cls
	 * @return
	 */
	public <T> T check(JLFJson json, Class<T> cls)  {
		T t;
		try {
			t = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		List<Field> fields = ReflectUtil.getAllFields(cls);
		for (Field field : fields) {
			JLFCheckAnn ann = field.getAnnotation(JLFCheckAnn.class);
			if (ann != null && ann.isSkipValidate() == true) {
				continue;
			}
			Class<?> fieldCls = field.getType();
			CheckBean<?> checkBean = CheckBeanFactory.getCheckBean(fieldCls);
			Object value = getValue(json, checkBean, field);
			checkValue(field, ann, checkBean, value);
			value = recursive(field, fieldCls, value);
			setValue(cls, t, field, fieldCls, value);
		}
		return t;
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:从json中获取字段的值
	 * @param json
	 * @param checkBean
	 * @param field
	 * @return
	 */
	private Object getValue(JLFJson json, CheckBean<?> checkBean, Field field)  {
		return checkBean.getObj().getValue(json, field);
	}

	/**
	 * 
	 * @Title: checkValue
	 * @Description:对参数值进行校验
	 * @param field
	 * @param checkBean
	 * @param value
	 */
	private void checkValue(Field field, JLFCheckAnn ann, CheckBean<?> checkBean, Object value)  {
		List<Method> methods = checkBean.getMethods();
		for (Method method : methods) {
			try {
				method.invoke(checkBean.getObj(), ann, field, value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
	}

	/**
	 * 
	 * @Title: recursive
	 * @Description:对自定义类型，以及list中泛型为自定义类型的，做递归，递归后返回真正的fieldValue,枚举类型除外
	 * @param field
	 * @param fieldCls
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object recursive(Field field, Class<?> fieldCls, Object value)  {
		if (IEnum.class.isAssignableFrom(fieldCls)) {
			return value;
		}
		if (value != null) {
			if (ClassUtil.clsIsCustom(fieldCls)) {
				return check((JLFJson) value, fieldCls);
			} else if (fieldCls.isAssignableFrom(List.class)) {
				Class<?> listTCls = GenericityUtil.getFieldGenerCls(field);
				if (ClassUtil.clsIsCustom(listTCls)) {
					return recursiveList(listTCls, fieldCls, (List<JLFJson>) value);
				}
			}
		}
		return value;
	}

	/**
	 * 
	 * @Title: recursiveList
	 * @Description:对list中泛型为自定义类型的做递归
	 * @param listTCls
	 * @param fieldCls
	 * @param values
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<?> recursiveList(Class<?> listTCls, Class<?> fieldCls, List<JLFJson> values)  {
		List list;
		try {
			list = (List) fieldCls.newInstance();
		} catch (Exception e) {
			list = new ArrayList();
		}

		for (JLFJson json : values) {
			list.add(check(json, listTCls));
		}
		return list;

	}

	/**
	 * 
	 * @Title: setValue
	 * @Description:将校验通过的值,赋给field
	 * @param cls
	 * @param obj
	 * @param field
	 * @param fieldCls
	 * @param value
	 */
	private void setValue(Class<?> cls, Object obj, Field field, Class<?> fieldCls, Object value)  {
		Method setMethod = ReflectUtil.createSetMothod(cls, field.getName(), fieldCls);
		try {
			setMethod.invoke(obj, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}
}
