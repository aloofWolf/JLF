package org.jlf.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 
 * @ClassName: GenericityUtil
 * @Description:泛型工具类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class GenericityUtil {
	
	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取方法参数中的第一个泛型所属的class
	 * @param field
	 * @return
	 */
	public static <T> Class<T> getParameterGenerCls(Parameter parameter) {
		return getParameterGenerCls(parameter, 0);
	}

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取方法参数中的index位置的泛型所属的class
	 * @param field
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getParameterGenerCls(Parameter parameter, int index) {
		return (Class<T>) ((ParameterizedType) parameter.getParameterizedType()).getActualTypeArguments()[index];
	}

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取成员变量字段中的第一个泛型所属的class
	 * @param field
	 * @return
	 */
	public static <T> Class<T> getFieldGenerCls(Field field) {
		return getFieldGenerCls(field, 0);
	}

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取成员变量字段中的index位置的泛型所属的class
	 * @param field
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getFieldGenerCls(Field field, int index) {
		return (Class<T>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[index];
	}

	/**
	 * 
	 * @Title: getObjSuperClsGenerCls
	 * @Description:获取当前对象继承类的第一个位置的泛型所属的class
	 * @param obj
	 * @return
	 */
	public static <T> Class<T> getObjSuperClsGenerCls(Class<?> obj) {
		return getObjSuperClsGenerCls(obj, 0);
	}

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:获取当前对象继承类的generIndex位置的泛型所属的class
	 * @param obj
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getObjSuperClsGenerCls(Class<?> obj, int generIndex) {
		return (Class<T>) ((ParameterizedType) obj.getGenericSuperclass()).getActualTypeArguments()[generIndex];
	}

	/**
	 * 
	 * @Title: getTClass
	 * @Description:获取当前对象实现的第一个位置接口的第一个位置的泛型所属的class
	 * @param obj
	 * @return
	 */
	public static <T> Class<T> getObjSuperInterGenerCls(Class<?> obj) {
		return getObjSuperInterGenerCls(obj, 0, 0);
	}

	/**
	 * 
	 * @Title: getObjSuperInterGenerCls
	 * @Description:获取当前对象实现的interIndex位置接口的generIndex位置的泛型所属的class
	 * @param obj
	 * @param interIndex
	 * @param generIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getObjSuperInterGenerCls(Class<?> obj, int interIndex, int generIndex) {
		return (Class<T>) ((ParameterizedType) obj.getGenericInterfaces()[interIndex])
				.getActualTypeArguments()[generIndex];
	}
	
	public void aa(List<String> list){}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		Method method = GenericityUtil.class.getDeclaredMethod("aa", List.class);
		Parameter[] ps = method.getParameters();
		for(Parameter p : ps){
			ParameterizedType pt = (ParameterizedType) p.getParameterizedType();
			Type[] pts = pt.getActualTypeArguments();
			for(Type t : pts){
				System.out.println(t.getTypeName());
			}
		}
		
	}
}
