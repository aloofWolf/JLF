package org.jlf.common.util;

/**
 * 
 * @ClassName: ClassUtil
 * @Description:Class������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class ClassUtil {

	/**
	 * 
	 * @Title: clsIsCustom
	 * @Description:�ж�class���Ƿ����û��Զ�������
	 * @param cls
	 * @return
	 */
	public static boolean clsIsCustom(Class<?> cls) {
		return cls.getClassLoader() != null;
	}

}
