package org.jlf.test.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.jlf.common.util.ReflectUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: ReflectUtilTest
 * @Description:反射工具类测试
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class ReflectUtilTest {

	/**
	 * 
	 * @Title: getAllFieldsTest
	 * @Description:获取cls的所有字段测试
	 */
	@Test
	public void getAllFieldsTest() {
		List<Field> fields = ReflectUtil.getAllFields(Child.class);
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
	
	/**
	 * 
	 * @Title: getAllMethodsTest
	 * @Description:获取cls的所有字段测试
	 */
	@Test
	public void getAllMethodsTest() {
		List<Method> fields = ReflectUtil.getAllMethods(Child.class);
		for (Method method : fields) {
			System.out.println(method.getName());
		}
	}
	
	

	/**
	 * 
	 * @Title: createSetMothod
	 * @Description:创建字段的set方法测试
	 * @param cls
	 * @param fieldName
	 * @param fieldType
	 * @return
	 * @throws Exception
	 */
	@Test
	public void createSetMothod() throws Exception {
		Method m = ReflectUtil.createSetMothod(Parent.class, "str", String.class);
		System.out.println(m.getName());
	}

	/**
	 * 
	 * @Title: createGetMothod
	 * @Description:创建字段的get方法
	 * @throws Exception
	 */
	@Test
	public void createGetMothod() throws Exception {
		Method m = ReflectUtil.createGetMothod(Parent.class, "str");
		System.out.println(m.getName());
	}

}

class Parent {

	private String str;
	private Long l;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

}

class Child extends Parent {

	private int i;
	private Object obj;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
