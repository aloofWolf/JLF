package org.jlf.test.common.util;

import org.jlf.common.util.FileUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: FileUtilTest
 * @Description:�ļ����������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class FileUtilTest {

	/**
	 * 
	 * @Title: createDirTest
	 * @Description:����Ŀ¼����
	 */
	@Test
	public void createDir() {
		String path = "J:/test";
		FileUtil.createDir(path);
	}

	/**
	 * 
	 * @Title: createFileTest
	 * @Description:�����ļ�����
	 */
	@Test
	public void createFileTest() {
		String path = "J:/test/test.xls";
		FileUtil.createFile(path);
	}

	/**
	 * 
	 * @Title: getDirByFilePath
	 * @Description:�����ļ�·����ȡ�ļ������ļ��в���
	 */
	@Test
	public void getDirByFilePath() {
		System.out.println(FileUtil.getDirByFilePath("J:\\test\\data.xls"));
		System.out.println(FileUtil.getDirByFilePath("J:/test/data.xls"));
	}

	/**
	 * 
	 * @Title: getFileNameByFilePath
	 * @Description:�����ļ�·����ȡ�ļ�������
	 */
	@Test
	public void getFileNameByFilePath() {
		System.out.println(FileUtil.getFileNameByFilePath("J:\\test\\data.xls"));
		System.out.println(FileUtil.getFileNameByFilePath("J:/test/data.xls"));
	}

	/**
	 * 
	 * @Title: strWriteToFile
	 * @Description:���ַ���д���ļ�����
	 */
	@Test
	public void strWriteToFile() {
		String str = "�����ַ���";
		String path = "J:/test/data.txt";
		FileUtil.strWriteToFile(str, path);

	}

}
