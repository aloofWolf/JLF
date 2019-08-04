package org.jlf.common.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * @ClassName: ClassLoaderUtil
 * @Description:类加载器工具类
 * @author Lone Wolf
 * @date 2019年6月10日
 */
public class ClassLoaderUtil {

	private static MyClassLoader loader = new MyClassLoader();

	/**
	 * 
	 * @Title: getOutCls
	 * @Description:加载外部jar包中的类
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
	 * @Description:获取自定义类加载器
	 * @return
	 */
	public static MyClassLoader getLoader() {
		return loader;
	}

	/**
	 * 
	 * @ClassName: MyClassLoader
	 * @Description:自定义类加载器
	 * @author Lone Wolf
	 * @date 2019年6月10日
	 */
	static class MyClassLoader extends URLClassLoader {

		/**
		 * 
		 * 创建一个新的实例 MyClassLoader.
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
