package org.jlf.common.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 
 * @ClassName: PackageUtil
 * @Description:package工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class PackageUtil {

	/**
	 * 
	 * @Title: getPackageClss
	 * @Description:获取包下的所有class类
	 * @param packageName
	 * @return
	 */
	public static List<Class<?>> getPackageClss(String packageName) {
		return getPackageClss(packageName, null);
	}

	/**
	 * 
	 * @Title: getPackageClss
	 * @Description:获取包下的所有class类,指定过滤器
	 * @param packageName
	 * @param filter
	 * @return
	 */
	public static List<Class<?>> getPackageClss(String packageName, PackageUtilFilter filter) {
		List<Class<?>> myClss = new ArrayList<Class<?>>();
		String filePath = packageName.replace(".", "/");
		ClassLoader loader = PackageUtil.class.getClassLoader();
		Enumeration<URL> urls = null;
		try {
			urls = loader.getResources(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			if (url != null) {
				String protocol = url.getProtocol();
				String pkgPath = url.getPath();
				if ("file".equals(protocol)) {
					myClss.addAll(processFile(pkgPath, null, filter));
				} else if ("jar".equals(protocol)) {
					myClss.addAll(processJar(url, filePath, filter));
				}
			}
		}
		return myClss;
	}

	/**
	 * 
	 * @Title: processFile
	 * @Description:递归获取file包下的所有class类
	 * @param filePath
	 * @param clss
	 * @param filter
	 * @return
	 */
	private static List<Class<?>> processFile(String filePath, List<Class<?>> clss, PackageUtilFilter filter) {
		List<Class<?>> myClss = new ArrayList<Class<?>>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClss.addAll(processFile(childFile.getPath(), myClss, filter));
			} else {
				String childFilePath = childFile.getPath();
				if (childFilePath.endsWith(".class")) {
					if (childFilePath.indexOf("\\classes") > 0) {
						childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9,
								childFilePath.indexOf("."));
					} else {
						childFilePath = childFilePath.substring(childFilePath.indexOf("\\test-classes") + 14,
								childFilePath.indexOf("."));
					}

					childFilePath = childFilePath.replace("\\", ".");
					try {
						Class<?> cls = Class.forName(childFilePath);
						if (filter == null || !filter.doFilter(cls)) {
							myClss.add(cls);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}

			}
		}
		return myClss;
	}

	/**
	 * 
	 * @Title: processJar
	 * @Description:递归获取jar包下的所有class类
	 * @param url
	 * @param packageName
	 * @param filter
	 * @return
	 */
	private static List<Class<?>> processJar(URL url, String packageName, PackageUtilFilter filter) {
		List<Class<?>> myClss = new ArrayList<Class<?>>();
		JarFile jar;
		try {
			jar = ((JarURLConnection) url.openConnection()).getJarFile();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		Enumeration<JarEntry> entries = jar.entries();
		while (entries.hasMoreElements()) {
			// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文
			JarEntry jarEntry = entries.nextElement();

			String name = jarEntry.getName();
			// 如果是以/开头的
			if (name.charAt(0) == '/') {
				// 获取后面的字符串
				name = name.substring(1);
			}

			if (jarEntry.isDirectory() || !name.startsWith(packageName) || !name.endsWith(".class")) {
				continue;
			}
			// 如果是一个.class文件 而且不是目录
			// 去掉后面的".class" 获取真正的类名
			String className = name.substring(0, name.length() - 6).replace("/", ".");
			try {
				Class<?> cls = Class.forName(className);
				if (filter == null || !filter.doFilter(cls)) {
					myClss.add(cls);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return myClss;
	}

}
