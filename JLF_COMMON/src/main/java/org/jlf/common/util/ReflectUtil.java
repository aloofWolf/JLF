package org.jlf.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @ClassName: ReflectUtil
 * @Description:反射工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class ReflectUtil {

	/**
	 * 
	 * @Title: getAllFields
	 * @Description:获取cls的所有字段，包括父类和各种访问权限
	 * @param cls
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> cls) {
		List<Field> fields = new ArrayList<Field>();
		while (cls != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			fields.addAll(0, Arrays.asList(cls.getDeclaredFields()));
			cls = cls.getSuperclass(); // 得到父类,然后赋给自己
		}
		return fields;
	}
	
	/**
	 * 
	 * @Title: getAllFields
	 * @Description:获取cls的所有字段，包括父类和各种访问权限
	 * @param cls
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> cls,Class<?> topCls) {
		List<Field> fields = new ArrayList<Field>();
		while (cls != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			if(cls.equals(topCls)){
				break;
			}
			fields.addAll(0, Arrays.asList(cls.getDeclaredFields()));
			cls = cls.getSuperclass(); // 得到父类,然后赋给自己
		}
		return fields;
	}
	
	/**
	 * 
	 * @Title: getAllMethods
	 * @Description:获取cls的所有字段，包括父类和各种访问权限
	 * @param cls
	 * @return
	 */
	public static List<Method> getAllMethods(Class<?> cls) {
		List<Method> methods = new ArrayList<Method>();
		while (cls != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			methods.addAll(0, Arrays.asList(cls.getDeclaredMethods()));
			cls = cls.getSuperclass(); // 得到父类,然后赋给自己
		}
		return methods;
	}
	
	/**
	 * 
	 * @Title: getAllMethods
	 * @Description:获取cls的所有字段，包括父类和各种访问权限
	 * @param cls
	 * @return
	 */
	public static List<Method> getAllMethods(Class<?> cls,Class<?> topCls) {
		List<Method> methods = new ArrayList<Method>();
		while (cls != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			if(cls.equals(topCls)){
				break;
			}
			methods.addAll(0, Arrays.asList(cls.getDeclaredMethods()));
			cls = cls.getSuperclass(); // 得到父类,然后赋给自己
		}
		return methods;
	}

	/**
	 * 
	 * @Title: createSetMothod
	 * @Description:创建字段的set方法
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
	 * @Description:创建字段的get方法
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
