package org.jlf.plugin.server.core.check.custom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.util.ClassUtil;
import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.server.core.check.custom.bean.CheckBean;
import org.jlf.plugin.server.core.check.custom.detail.fac.CheckBeanFactory;
import org.jlf.plugin.server.core.check.custom.enums.JLFCheckType;

/**
 * 
 * @ClassName: CheckWolf
 * @Description:CheckWolf����
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class CheckCustom implements JLFCheck {
	
	/**
	 * ���Ѿ�У�����cls�Ͷ�Ӧ��fields���浽��map,����ÿ�ζ����»�ȡfields
	 */
	private static Map<Class<?>,List<Field>> checkClsMap = new HashMap<Class<?>,List<Field>>();
	
	private static Map<Method,Parameter[]> checkMethodMap = new HashMap<Method,Parameter[]>();

	@Override
	public <T> T check(String jsonStr, Class<T> cls) {
		JLFJson json = JLFJsonClient.get().jsonStrToJson(jsonStr);
		return checkCls(json, cls);
	}

	@Override
	public <T> T check(Map<String, Object> map, Class<T> cls) {
		JLFJson json = JLFJsonClient.get().mapToJson(map);
		return checkCls(json, cls);
	}

	@Override
	public Object[] check(String jsonStr, Method method) {
		JLFJson json = JLFJsonClient.get().jsonStrToJson(jsonStr);
		return checkMethod(json, method);
	}

	@Override
	public Object[] check(Map<String, Object> map, Method method) {
		JLFJson json = JLFJsonClient.get().mapToJson(map);
		return checkMethod(json, method);
	}
	
	/**
	 * 
	 * @Title: checkCls
	 * @Description:��JSONObject����check
	 * @param json
	 * @param cls
	 * @return
	 */
	public <T> T checkCls(JLFJson json, Class<T> cls) {
		T t;
		try {
			t = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		
		List<Field> fields = null;
		synchronized(this){
			fields = checkClsMap.get(cls);
			if(fields == null){
				fields = ReflectUtil.getAllFields(cls);
				checkClsMap.put(cls, fields);
			}
		}
		
		for (Field field : fields) {
			JLFCheckAnn ann = field.getAnnotation(JLFCheckAnn.class);
			if (ann != null && ann.isSkipValidate() == true) {
				continue;
			}
			String fieldName = field.getName();
			Class<?> fieldCls = field.getType();
			CheckBean<?> checkBean = CheckBeanFactory.getCheckBean(fieldCls);
			Object value = getValue(json, checkBean, field,JLFCheckType.FIELD,field.getType(),field.getName());
			checkValue(fieldName, ann, checkBean, value);
			value = recursive(field,JLFCheckType.FIELD, fieldCls, value);
			setValue(cls, t, field, fieldCls, value);
		}
		return t;
	}
	
	/**
	 * 
	 * @Title: checkCls
	 * @Description:��JSONObject����check
	 * @param json
	 * @param cls
	 * @return
	 */
	public Object[] checkMethod(JLFJson json, Method method) {
		
		Parameter[] parameters = null;
		synchronized(this){
			parameters = checkMethodMap.get(method);
			if(parameters == null){
				parameters = method.getParameters();
				checkMethodMap.put(method, parameters);
			}
		}
		Object[] values = new Object[parameters.length];
		int index = 0;
		for (Parameter parameter : parameters) {
			JLFCheckAnn ann = parameter.getAnnotation(JLFCheckAnn.class);
			if (ann != null && ann.isSkipValidate() == true) {
				continue;
			}
			String parameterName = parameter.getName();
			Class<?> fieldCls = parameter.getType();
			CheckBean<?> checkBean = CheckBeanFactory.getCheckBean(fieldCls);
			Object value = getValue(json, checkBean, parameter,JLFCheckType.PARAMETER,parameter.getType(),parameter.getName());
			checkValue(parameterName, ann, checkBean, value);
			value = recursive(parameter,JLFCheckType.PARAMETER, fieldCls, value);
			values[index] = value;
			index = index + 1;
		}
		return values;
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:��json�л�ȡ�ֶε�ֵ
	 * @param json
	 * @param checkBean
	 * @param field
	 * @return
	 */
	private Object getValue(JLFJson json, CheckBean<?> checkBean,  Object CheckObj,JLFCheckType type,Class<?> checkCls,String checkName) {
		return checkBean.getObj().getValue(json, CheckObj,type,checkCls,checkName);
	}

	/**
	 * 
	 * @Title: checkValue
	 * @Description:�Բ���ֵ����У��
	 * @param field
	 * @param checkBean
	 * @param value
	 */
	private void checkValue(String checkName, JLFCheckAnn ann, CheckBean<?> checkBean, Object value) {
		List<Method> methods = checkBean.getMethods();
		for (Method method : methods) {
			try {
				method.invoke(checkBean.getObj(), ann, checkName, value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
	}

	/**
	 * 
	 * @Title: recursive
	 * @Description:���Զ������ͣ��Լ�list�з���Ϊ�Զ������͵ģ����ݹ飬�ݹ�󷵻�������fieldValue,ö�����ͳ���
	 * @param field
	 * @param fieldCls
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object recursive(Object checkObj,JLFCheckType type, Class<?> checkCls, Object value) {
		if (IEnum.class.isAssignableFrom(checkCls)) {
			return value;
		}
		if (value != null) {
			if (ClassUtil.clsIsCustom(checkCls)) {
				return checkCls((JLFJson) value, checkCls);
			} else if (checkCls.isAssignableFrom(List.class)) {
				Class<?> listTCls = null;  //��ȡlist�з��͵�����
				if(type.equals(JLFCheckType.FIELD)){
					listTCls = GenericityUtil.getFieldGenerCls((Field) checkObj);
				}else{
					listTCls = GenericityUtil.getParameterGenerCls((Parameter) checkObj);
				}
				if (ClassUtil.clsIsCustom(listTCls)) {
					return recursiveList(listTCls, checkCls, (List<JLFJson>) value);
				}
			}
		}
		return value;
	}

	/**
	 * 
	 * @Title: recursiveList
	 * @Description:��list�з���Ϊ�Զ������͵����ݹ�
	 * @param listTCls
	 * @param fieldCls
	 * @param values
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<?> recursiveList(Class<?> listTCls, Class<?> fieldCls, List<JLFJson> values) {
		List list;
		try {
			list = (List) fieldCls.newInstance();
		} catch (Exception e) {
			list = new ArrayList();
		}

		for (JLFJson json : values) {
			list.add(checkCls(json, listTCls));
		}
		return list;

	}

	/**
	 * 
	 * @Title: setValue
	 * @Description:��У��ͨ����ֵ,����field
	 * @param cls
	 * @param obj
	 * @param field
	 * @param fieldCls
	 * @param value
	 */
	private void setValue(Class<?> cls, Object obj, Field field, Class<?> fieldCls, Object value) {
		Method setMethod = ReflectUtil.createSetMothod(cls, field.getName(), fieldCls);
		try {
			setMethod.invoke(obj, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	

	
}
