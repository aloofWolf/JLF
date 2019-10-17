package org.jlf.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: IniUtil
 * @Description:.ini文件工具类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class IniUtil {

	/**
	 * 
	 * @Title: parse
	 * @Description: 解析.ini文件,默认使用GBK编码
	 * @param fileName
	 * @return
	 */
	public static IniContent parse(String fileName) {
		return parse(fileName, "GBK");
	}

	/**
	 * 
	 * @Title: parse
	 * @Description: 解析.ini文件,调用者指定编码
	 * @param fileName
	 * @param character
	 * @return
	 */
	public static IniContent parse(String fileName, String character) {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream(fileName), character);
			BufferedReader reader = new BufferedReader(isr);
			IniContent content = read(reader);
			reader.close();
			return content;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 
	 * @Title: read
	 * @Description:遍历每一行数据
	 * @param reader
	 */
	private static IniContent read(BufferedReader reader) {
		IniContent content = new IniContent();
		List<IniContent> contents = new LinkedList<IniContent>();
		contents.add(content);
		List<String> sectionNames = new LinkedList<String>();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				parseLine(line, contents, sectionNames);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return content;
	}

	/**
	 * 
	 * @Title: parseLine
	 * @Description:解析每一行数据
	 * @param line
	 */
	private static void parseLine(String line, List<IniContent> contents, List<String> sectionNames) {
		line = line.trim();
		if (line.matches("\\[/.*\\]")) {
			String currSecionName = sectionNames.get(0);
			if (line.replaceFirst("\\[/(.*)\\]", "$1").equals(currSecionName)) {
				sectionNames.remove(0);
				contents.remove(0);
			} else {
				throw new RuntimeException(".ini文件格式有误");
			}
		} else if (line.matches("\\[.*\\]")) {

			String sectionName = line.replaceFirst("\\[(.*)\\]", "$1");
			IniContent currContent = contents.get(0);
			IniContent newContent = new IniContent();
			if (currContent.getSectionArr(sectionName) != null) {
				currContent.putSectionArr(sectionName, newContent);
			} else if (currContent.getSection(sectionName) != null) {
				currContent.putSectionArr(sectionName, currContent.getSection(sectionName));
				currContent.putSectionArr(sectionName, newContent);
				currContent.removeSection(sectionName);
			} else {
				currContent.putSection(sectionName, newContent);
			}
			sectionNames.add(0, sectionName);
			contents.add(0, newContent);
		} else if (line.matches("^#[^#]*$")) {

		} else {
			Pattern line_pattern = Pattern.compile("([^#=]*)=([^#=]*)(#)?.*");
			Matcher matcher = line_pattern.matcher(line);
			if (matcher.matches()) {
				String name = matcher.group(1).trim();
				String value = matcher.group(2).trim();
				IniContent currContent = contents.get(0);
				currContent.putProp(name, value);
			}
		}
	}

}
