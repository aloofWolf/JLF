package org.jlf.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @ClassName: ReflectUtil
 * @Description:���乤����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class ReflectUtil {

	/**
	 * 
	 * @Title: getAllFields
	 * @Description:��ȡcls�������ֶΣ���������͸��ַ���Ȩ��
	 * @param cls
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> cls) {
		List<Field> fields = new ArrayList<Field>();
		while (cls != null) {// ������Ϊnull��ʱ��˵�����������ϲ�ĸ���(Object��).
			fields.addAll(0, Arrays.asList(cls.getDeclaredFields()));
			cls = cls.getSuperclass(); // �õ�����,Ȼ�󸳸��Լ�
		}
		return fields;
	}
	
	/**
	 * 
	 * @Title: getAllFields
	 * @Description:��ȡcls�������ֶΣ���������͸��ַ���Ȩ��
	 * @param cls
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> cls,Class<?> topCls) {
		List<Field> fields = new ArrayList<Field>();
		while (cls != null) {// ������Ϊnull��ʱ��˵�����������ϲ�ĸ���(Object��).
			if(cls.equals(topCls)){
				break;
			}
			fields.addAll(0, Arrays.asList(cls.getDeclaredFields()));
			cls = cls.getSuperclass(); // �õ�����,Ȼ�󸳸��Լ�
		}
		return fields;
	}
	
	/**
	 * 
	 * @Title: getAllMethods
	 * @Description:��ȡcls�������ֶΣ���������͸��ַ���Ȩ��
	 * @param cls
	 * @return
	 */
	public static List<Method> getAllMethods(Class<?> cls) {
		List<Method> methods = new ArrayList<Method>();
		while (cls != null) {// ������Ϊnull��ʱ��˵�����������ϲ�ĸ���(Object��).
			methods.addAll(0, Arrays.asList(cls.getDeclaredMethods()));
			cls = cls.getSuperclass(); // �õ�����,Ȼ�󸳸��Լ�
		}
		return methods;
	}
	
	/**
	 * 
	 * @Title: getAllMethods
	 * @Description:��ȡcls�������ֶΣ���������͸��ַ���Ȩ��
	 * @param cls
	 * @return
	 */
	public static List<Method> getAllMethods(Class<?> cls,Class<?> topCls) {
		List<Method> methods = new ArrayList<Method>();
		while (cls != null) {// ������Ϊnull��ʱ��˵�����������ϲ�ĸ���(Object��).
			if(cls.equals(topCls)){
				break;
			}
			methods.addAll(0, Arrays.asList(cls.getDeclaredMethods()));
			cls = cls.getSuperclass(); // �õ�����,Ȼ�󸳸��Լ�
		}
		return methods;
	}

	/**
	 * 
	 * @Title: createSetMothod
	 * @Description:�����ֶε�set����
	 * @param cls
	 * @param fieldName
	 * @param fieldType
	 * @return
	 * @throws Exception
	 */
	public static Method createSetMothod(Class<?> cls, String fieldName, Class<?> fieldType) throws Exception {
		String methodStr = new StringBuffer("set").append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1)).toString();
		Method method = cls.getMethod(methodStr, fieldType);
		return method;
	}

	/**
	 * 
	 * @Title: createSetMothod
	 * @Description:�����ֶε�get����
	 * @param cls
	 * @param fieldName
	 * @param fieldType
	 * @return
	 * @throws Exception
	 */
	public static Method createGetMothod(Class<?> cls, String fieldName) throws Exception {
		String methodStr = new StringBuffer("get").append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1)).toString();
		Method method = cls.getMethod(methodStr);
		return method;
	}
}
