package org.jlf.common.util;

/**
 * 
 * @ClassName: PathUtil
 * @Description:路径工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class PathUtil {

	/**
	 * 
	 * @Title: getConfigFilePath
	 * @Description:获取JLF配置文件路径
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
