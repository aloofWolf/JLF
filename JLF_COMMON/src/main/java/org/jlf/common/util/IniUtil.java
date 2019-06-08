package org.jlf.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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

	private Properties pros = new Properties(); // 存储标签之外的属性
	private Map<String, Properties> sections = new HashMap<String, Properties>();// 存储标签之内的属性
	private String secionName;
	private Properties secionProps;

	/**
	 * 
	 * 创建一个新的实例 IniUtil,默认使用GBK编码.
	 * 
	 * @param filename
	 * @throws Exception
	 */
	public IniUtil(String fileName) throws Exception {
		this(fileName, "GBK");
	}

	/**
	 * 
	 * 创建一个新的实例 IniUtil,调用者指定编码.
	 * 
	 * @param filename
	 * @throws Exception
	 */
	public IniUtil(String fileName, String character) throws Exception {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), character);
		BufferedReader reader = new BufferedReader(isr);
		read(reader);
		reader.close();
	}

	/**
	 * 
	 * @Title: read
	 * @Description:遍历每一行数据
	 * @param reader
	 * @throws Exception
	 */
	private void read(BufferedReader reader) throws Exception {
		String line;
		while ((line = reader.readLine()) != null) {
			parseLine(line);
		}
	}

	/**
	 * 
	 * @Title: parseLine
	 * @Description:解析每一行数据
	 * @param line
	 * @throws Exception
	 */
	private void parseLine(String line) throws Exception {
		line = line.trim();
		if (line.matches("\\[/.*\\]")) {

			if (line.replaceFirst("\\[/(.*)\\]", "$1").equals(secionName)) {
				secionName = null;
				secionProps = null;
			} else {
				throw new Exception("");
			}
		} else if (line.matches("\\[.*\\]")) {
			if (secionName != null) {
				throw new Exception("");
			}
			secionName = line.replaceFirst("\\[(.*)\\]", "$1");
			secionProps = new Properties();
			sections.put(secionName, secionProps);
		} else if (line.matches("^#[^#]*$")) {

		} else {
			Pattern line_pattern = Pattern.compile("([^#=]*)=([^#=]*)(#)?.*");
			Matcher matcher = line_pattern.matcher(line);
			if (matcher.matches()) {
				String name = matcher.group(1).trim();
				String value = matcher.group(2).trim();
				if (secionProps != null) {

					secionProps.setProperty(name, value);
				} else {
					pros.setProperty(name, value);
				}
			}
		}
	}

	/**
	 * 
	 * @Title: getSection
	 * @Description:获取标签内的全部属性
	 * @param section
	 * @return
	 */
	public Properties getSection(String section) {
		return sections.get(section);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:获取标签外的数据值
	 * @param name
	 * @return
	 */
	public String getValue(String name) {
		return pros.getProperty(name);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:获取标签内的某个属性值
	 * @param section
	 * @param name
	 * @return
	 */
	public String getValue(String section, String name) {
		Properties p = (Properties) sections.get(section);

		if (p == null) {
			return null;
		}
		String value = p.getProperty(name);
		return value;
	}

	/**
	 * 
	 * @Title: getPros
	 * @Description:pros
	 * @return
	 */
	public Properties getPros() {
		return pros;
	}

	/**
	 * 
	 * @Title: getSections
	 * @Description:sections
	 * @return
	 */
	public Map<String, Properties> getSections() {
		return sections;
	}

}
