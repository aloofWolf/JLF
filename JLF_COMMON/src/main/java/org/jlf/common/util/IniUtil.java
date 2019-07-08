package org.jlf.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jlf.common.exception.JLFException;

/**
 * 
 * @ClassName: IniUtil
 * @Description:.ini�ļ�������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class IniUtil {

	private Properties pros = new Properties(); // �洢��ǩ֮�������
	private Map<String, Properties> sections = new HashMap<String, Properties>();// �洢��ǩ֮�ڵ�����
	private String secionName;
	private Properties secionProps;

	/**
	 * 
	 * ����һ���µ�ʵ�� IniUtil,Ĭ��ʹ��GBK����.
	 * 
	 * @param filename
	 */
	public IniUtil(String fileName) {
		this(fileName, "GBK");
	}

	/**
	 * 
	 * ����һ���µ�ʵ�� IniUtil,������ָ������.
	 * 
	 * @param filename
	 */
	public IniUtil(String fileName, String character) {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream(fileName), character);
			BufferedReader reader = new BufferedReader(isr);
			read(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	/**
	 * 
	 * @Title: read
	 * @Description:����ÿһ������
	 * @param reader
	 */
	private void read(BufferedReader reader) {
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				parseLine(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: parseLine
	 * @Description:����ÿһ������
	 * @param line
	 */
	private void parseLine(String line) {
		line = line.trim();
		if (line.matches("\\[/.*\\]")) {

			if (line.replaceFirst("\\[/(.*)\\]", "$1").equals(secionName)) {
				secionName = null;
				secionProps = null;
			} else {
				throw new JLFException(".ini�ļ���ʽ����");
			}
		} else if (line.matches("\\[.*\\]")) {
			if (secionName != null) {
				throw new JLFException(".ini�ļ���ʽ����");
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
	 * @Description:��ȡ��ǩ�ڵ�ȫ������
	 * @param section
	 * @return
	 */
	public Properties getSection(String section) {
		return sections.get(section);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:��ȡ��ǩ�������ֵ
	 * @param name
	 * @return
	 */
	public String getValue(String name) {
		return pros.getProperty(name);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description:��ȡ��ǩ�ڵ�ĳ������ֵ
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
