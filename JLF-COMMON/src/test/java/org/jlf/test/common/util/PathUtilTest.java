package org.jlf.test.common.util;

import org.jlf.common.util.PathUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: PathUtilTest
 * @Description:·��������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class PathUtilTest {

	/**
	 * 
	 * @Title: getConfigFilePathTest
	 * @Description:��ȡ��Ŀ��·������
	 */
	@Test
	public void getRootPathTest() {
		String path = PathUtil.getRootPath();
		System.out.println(path);
	}

	/**
	 * 
	 * @Title: getConfigFilePathTest
	 * @Description:��ȡJLF�����ļ�·������
	 */
	@Test
	public void getConfigFilePathTest() {
		String path = PathUtil.getConfigFilePath();
		System.out.println(path);
	}

}
