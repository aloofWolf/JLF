package org.jlf.test.common.util;

import org.jlf.common.util.FileUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: FileUtilTest
 * @Description:文件工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class FileUtilTest {

	/**
	 * 
	 * @Title: createDirTest
	 * @Description:创建目录测试
	 */
	@Test
	public void createDir() {
		String path = "J:/test";
		FileUtil.createDir(path);
	}

	/**
	 * 
	 * @Title: createFileTest
	 * @Description:创建文件测试
	 */
	@Test
	public void createFileTest() {
		String path = "J:/test/test.xls";
		FileUtil.createFile(path);
	}

	/**
	 * 
	 * @Title: getDirByFilePath
	 * @Description:根据文件路径获取文件所在文件夹测试
	 */
	@Test
	public void getDirByFilePath() {
		System.out.println(FileUtil.getDirByFilePath("J:\\test\\data.xls"));
		System.out.println(FileUtil.getDirByFilePath("J:/test/data.xls"));
	}

	/**
	 * 
	 * @Title: getFileNameByFilePath
	 * @Description:根据文件路径获取文件名测试
	 */
	@Test
	public void getFileNameByFilePath() {
		System.out.println(FileUtil.getFileNameByFilePath("J:\\test\\data.xls"));
		System.out.println(FileUtil.getFileNameByFilePath("J:/test/data.xls"));
	}

	/**
	 * 
	 * @Title: strWriteToFile
	 * @Description:将字符串写入文件测试
	 */
	@Test
	public void strWriteToFile() {
		String str = "我是字符串";
		String path = "J:/test/data.txt";
		FileUtil.strWriteToFile(str, path);

	}

}
