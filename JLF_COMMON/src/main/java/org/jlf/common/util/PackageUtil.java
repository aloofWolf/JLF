package org.jlf.common.util;

import java.io.File;
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
 * @Description:package������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class PackageUtil {

	/**
	 * 
	 * @Title: getPackageClss
	 * @Description:��ȡ���µ�����class��
	 * @param packagePath
	 * @return
	 * @throws Exception
	 */
	public static List<Class<?>> getPackageClss(String packageName) throws Exception {
		//String filePath = PackageUtil.class.getClassLoader().getResource("").getPath() + packageName.replace(".", "\\");
		List<Class<?>> myClss = new ArrayList<Class<?>>();
		String filePath = packageName.replace(".", "/");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = loader.getResources(filePath);
		 while(urls.hasMoreElements()){
             URL url = urls.nextElement();
             if(url != null){
                 String protocol = url.getProtocol();
                 String pkgPath = url.getPath();
                 System.out.println(protocol);
                 System.out.println(pkgPath);
                 if("file".equals(protocol)){
                	 myClss.addAll(processFile(pkgPath,null));
                 }else if("jar".equals(protocol)){
                	 myClss.addAll(processJar(url,filePath));
                 }
             }
         }
		return myClss;
	}
	
	public static void main(String[] args) throws Exception{
		List<Class<?>> list = getPackageClss("org");
		for(Class<?> cls : list){
			System.out.println(cls.getName());
		}
	}

	/**
	 * 
	 * @Title: getPackageClss
	 * @Description:�ݹ��ȡ���µ�����class��
	 * @param filePath
	 * @param className
	 * @return
	 * @throws Exception
	 */
	private static List<Class<?>> processFile(String filePath, List<Class<?>> clss) throws Exception {
		List<Class<?>> myClss = new ArrayList<Class<?>>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				myClss.addAll(processFile(childFile.getPath(), myClss));
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
					myClss.add(Class.forName(childFilePath));
				}

			}
		}

		return myClss;
	}
	
	private static List<Class<?>> processJar(URL url,String packageName) throws Exception{
		
		List<Class<?>> myClss = new ArrayList<Class<?>>();
        JarFile jar;
        jar = ((JarURLConnection) url.openConnection()).getJarFile();
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            // ��ȡjar���һ��ʵ�� ������Ŀ¼ ��һЩjar����������ļ� ��META-INF����
        	JarEntry jarEntry = entries.nextElement();
 
        	String  name = jarEntry.getName();
            // �������/��ͷ��
            if (name.charAt(0) == '/') {
             // ��ȡ������ַ���
                name = name.substring(1);
            }
 
            if (jarEntry.isDirectory() || !name.startsWith(packageName) || !name.endsWith(".class")) {
                continue;
            }
            //�����һ��.class�ļ� ���Ҳ���Ŀ¼
            // ȥ�������".class" ��ȡ����������
            String className = name.substring(0, name.length() - 6).replace("/", ".");
            myClss.add(Class.forName(className));
        }
        return myClss;
	}
            

}
