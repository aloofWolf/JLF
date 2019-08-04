package org.jlf.common.util;

/**
 * 
 * @ClassName: PathUtil
 * @Description:·��������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class PathUtil {

	/**
	 * 
	 * @Title: getRootPath
	 * @Description:��ȡ��Ŀ��·��
	 * @return
	 */
	public static String getRootPath() {
		return PathUtil.class.getClassLoader().getResource("").getPath();
	}

	/**
	 * 
	 * @Title: getConfigFilePath
	 * @Description:��ȡJLF�����ļ�·��
	 * @return
	 */
	public static String getConfigFilePath() {
		String path = null;
		try {
			path = PathUtil.class.getClassLoader().getResource("").getPath() + "JLF/";
		} catch (Exception e) {
			path = "JLF/";
		}
		return path;
	}

}