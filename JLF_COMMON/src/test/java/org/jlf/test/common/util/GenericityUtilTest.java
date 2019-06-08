package org.jlf.test.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.GenericityUtil;
import org.junit.Test;

public class GenericityUtilTest {

	/**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:获取成员变量字段中的泛型所属的class测试
	 * @throws Exception
	 */
	@Test
	public <T> void getFieldGenerCls() throws Exception {
		Field field = ChildC.class.getDeclaredField("l");
		System.out.println(GenericityUtil.getFieldGenerCls(field));
		System.out.println(GenericityUtil.getFieldGenerCls(field, 2));
	}

	/**
	 * 
	 * @Title: getObjGenerCls
	 * @Description:获获取当前对象的泛型所属的class测试
	 */
	@Test
	public <T> void getObjGenerCls() {
		System.out.println(GenericityUtil.getObjGenerCls(ChildC.class));
		System.out.println(GenericityUtil.getObjGenerCls(ChildC.class, 2));
	}

}

class ParentC<T extends Object, V extends List<?>> {

}

class ChildC extends ParentC<Long, ArrayList<Integer>> {

	@SuppressWarnings("unused")
	private Map<String, Long> l;

}
