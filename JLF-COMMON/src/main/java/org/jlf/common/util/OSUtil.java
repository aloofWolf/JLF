package org.jlf.common.util;

import java.util.Properties;

/**
 * 
 * @ClassName: OSUtil
 * @Description:����ϵͳ������
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class OSUtil {

	static final Properties PROPERTIES = new Properties(System.getProperties());

	/**
	 * 
	 * @Title: getLineSeparator
	 * @Description:��ȡ�зָ���
	 * @return
	 */
	public static String getLineSeparator() {
		return PROPERTIES.getProperty("line.separator");
	}

	/**
	 * 
	 * @Title: getPathSeparator
	 * @Description:��ȡ�ļ�·���ָ���
	 * @return
	 */
	public static String getPathSeparator() {
		return PROPERTIES.getProperty("file.separator");
	}

}
