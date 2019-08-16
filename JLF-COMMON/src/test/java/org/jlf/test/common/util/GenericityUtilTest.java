package org.jlf.test.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.GenericityUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: GenericityUtilTest
 * @Description:���͹��������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class GenericityUtilTest {

	/**
	 * 
	 * @Title: getParameterGenerCls
	 * @Description:��ȡ���������еķ���������class����
	 *//*
	@Test
	public <T> void getParameterGenerCls() {
		Method method = null;
		try {
			method = GenericityUtilTest.class.getDeclaredMethod("test", List.class, Map.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parameter parameter = method.getParameters()[1];
		System.out.println(GenericityUtil.getParameterGenerCls(parameter));
		System.out.println(GenericityUtil.getParameterGenerCls(parameter, 1));
	}

	*//**
	 * 
	 * @Title: getFieldGenerCls
	 * @Description:��ȡ��Ա�����ֶ��еķ���������class����
	 *//*
	@Test
	public <T> void getFieldGenerCls() {
		Field field = null;
		try {
			field = ChildC.class.getDeclaredField("l");
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		System.out.println(GenericityUtil.getFieldGenerCls(field));
		System.out.println(GenericityUtil.getFieldGenerCls(field, 1));
	}

	*//**
	 * 
	 * @Title: getObjSuperClsGenerCls
	 * @Description:���ȡ��ǰ����̳���ķ���������class����
	 *//*
	@Test
	public <T> void getObjSuperClsGenerCls() {
		System.out.println(GenericityUtil.getObjSuperClsGenerCls(ChildC.class));
		System.out.println(GenericityUtil.getObjSuperClsGenerCls(ChildC.class, 1));
	}

	*//**
	 * 
	 * @Title: getObjSuperClsGenerCls
	 * @Description:���ȡ��ǰ����ʵ�ֽӿڵķ���������class����
	 *//*
	@Test
	public <T> void getObjSuperInterGenerCls() {
		System.out.println(GenericityUtil.getObjSuperInterGenerCls(ChildI.class));
		System.out.println(GenericityUtil.getObjSuperInterGenerCls(ChildI.class, 0, 1));
	}

	public void test(List<String> list, Map<Long, Object> map) {
	}*/
}

/*class ParentC<T extends Object, V extends List<?>> {

}

@SuppressWarnings("rawtypes")
class ChildC extends ParentC<Long, ArrayList> {

	@SuppressWarnings("unused")
	private Map<String, Long> l;

}

interface ParentI<T extends Object, V extends List<?>> {

}

@SuppressWarnings("rawtypes")
class ChildI implements ParentI<Long, ArrayList> {

	@SuppressWarnings("unused")
	private Map<String, Long> l;

}
*/