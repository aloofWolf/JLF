package org.jlf.common.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * @ClassName: ClassLoaderUtil
 * @Description:�������������
 * @author Lone Wolf
 * @date 2019��6��10��
 */
public class ClassLoaderUtil {

	private static MyClassLoader loader = new MyClassLoader();

	/**
	 * 
	 * @Title: getOutCls
	 * @Description:�����ⲿjar���е���
	 * @param path
	 * @param clsName
	 * @return
	 */
	public static Class<?> getOutCls(String path, String clsName) {
		loader.addPath(path);
		Class<?> cls = null;
		try {
			cls = loader.loadClass(clsName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return cls;
	}

	/**
	 * 
	 * @Title: getLoader
	 * @Description:��ȡ�Զ����������
	 * @return
	 */
	public static MyClassLoader getLoader() {
		return loader;
	}

	/**
	 * 
	 * @ClassName: MyClassLoader
	 * @Description:�Զ����������
	 * @author Lone Wolf
	 * @date 2019��6��10��
	 */
	static class MyClassLoader extends URLClassLoader {

		/**
		 * 
		 * ����һ���µ�ʵ�� MyClassLoader.
		 *
		 * @param path
		 */
		public MyClassLoader() {
			super(new URL[] {}, ClassLoaderUtil.class.getClassLoader());
		}

		/**
		 * 
		 * @Title: addPath
		 * @Description:addPath
		 * @param path
		 */
		public void addPath(String path) {
			try {
				super.addURL(new URL(path));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
