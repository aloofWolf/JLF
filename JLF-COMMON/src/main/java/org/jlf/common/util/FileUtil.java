package org.jlf.common.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @ClassName: FileUtil
 * @Description:file������
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class FileUtil {

	/**
	 * 
	 * @Title: isExists
	 * @Description:�ж�Ŀ¼���ļ��Ƿ����
	 * @param path
	 * @return
	 */
	public static boolean isExists(String path) {
		File file = new File(path);
		if (file.exists()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: createDir
	 * @Description:����Ŀ¼
	 * @param path
	 * @return
	 */
	public static File createDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	/**
	 * 
	 * @Title: createFile
	 * @Description:�����ļ�
	 * @param path
	 * @return
	 */
	public static File createFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return file;
	}

	/**
	 * 
	 * @Title: getDirByFilePath
	 * @Description:�����ļ�·����ȡ�ļ������ļ���
	 * @param filePath
	 * @return
	 */
	public static String getDirByFilePath(String filePath) {
		if (filePath == null) {
			return "";
		}
		String replaceFilePath = filePath.replaceAll("\\\\", "/");
		if (replaceFilePath.lastIndexOf("/") == -1) {
			return "";
		}
		return replaceFilePath.substring(0, replaceFilePath.lastIndexOf("/"));
	}

	/**
	 * 
	 * @Title: getFileNameByFilePath
	 * @Description:�����ļ�·����ȡ�ļ���
	 * @param filePath
	 * @return
	 */
	public static String getFileNameByFilePath(String filePath) {
		if (filePath == null) {
			return "";
		}
		String replaceFilePath = filePath.replaceAll("\\\\", "/");
		if (replaceFilePath.lastIndexOf("/") == -1) {
			return filePath;
		}
		return replaceFilePath.substring(replaceFilePath.lastIndexOf("/") + 1, replaceFilePath.length());
	}

	/**
	 * 
	 * @Title: strWriteToFile
	 * @Description:���ַ���д���ļ�
	 * @param str
	 * @param path
	 */
	public static void strWriteToFile(String str, String path) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(path);
			writer.write(str);
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
