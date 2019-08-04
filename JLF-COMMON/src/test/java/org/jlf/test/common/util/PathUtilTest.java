package org.jlf.test.common.util;

import org.jlf.common.util.PathUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: PathUtilTest
 * @Description:路径工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class PathUtilTest {

	/**
	 * 
	 * @Title: getConfigFilePathTest
	 * @Description:获取项目根路径测试
	 */
	@Test
	public void getRootPathTest() {
		String path = PathUtil.getRootPath();
		System.out.println(path);
	}

	/**
	 * 
	 * @Title: getConfigFilePathTest
	 * @Description:获取JLF配置文件路径测试
	 */
	@Test
	public void getConfigFilePathTest() {
		String path = PathUtil.getConfigFilePath();
		System.out.println(path);
	}

}
