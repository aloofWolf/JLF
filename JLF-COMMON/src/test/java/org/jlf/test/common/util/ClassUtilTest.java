package org.jlf.test.common.util;

import org.jlf.common.util.ClassUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: ClassUtilTest
 * @Description:Class���������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class ClassUtilTest {

	/**
	 * 
	 * @Title: clsIsCustom
	 * @Description:�ж�class���Ƿ����û��Զ�������
	 */
	@Test
	public <T> void clsIsCustom() {
		System.out.println(ClassUtil.clsIsCustom(String.class));
		System.out.println(ClassUtil.clsIsCustom(ChildC.class));
	}

}
