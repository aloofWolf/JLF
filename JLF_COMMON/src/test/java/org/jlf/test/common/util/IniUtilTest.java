package org.jlf.test.common.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jlf.common.util.IniUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: IniUtilTest
 * @Description:.ini���������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class IniUtilTest {

	/**
	 * 
	 * @Title: regex
	 * @Description:������ʽ����
	 */
	@Test
	public void regex() {

		String s6 = "123=three#����Ĳ�Ҫ";
		Pattern p = Pattern.compile("([^#=]*)=([^=#]*)(#)?.*");
		Matcher m = p.matcher(s6);
		System.out.println(m);
		System.out.println(m.matches());
		System.out.println(m.group());
		System.out.println(m.group(1));
		System.out.println(m.group(2));
		System.out.println(m.group(3));

		System.out.println("[MAIL_CONFIG]".matches("\\[/.*\\]"));
		System.out.println("[/SMS_CONFIG]".matches("\\[/.*\\]"));
		System.out.println("[MAIL_CONFIG]".replaceFirst("\\[(.*)\\]", "$1"));

	}

	/**
	 * 
	 * @Title: iniRead
	 * @Description:��ini�ļ���ȡ���ܲ���
	 * @throws Exception
	 */
	@Test
	public void iniRead() throws Exception {
		IniUtil ini = new IniUtil("I:/workspace/SKLF/cfm-main/cfm/src/main/resources/cfm_config.ini");
		Properties pros = ini.getPros();
		if (pros != null) {
			for (Enumeration<Object> keys = pros.keys(); keys.hasMoreElements();) {
				String key = (String) keys.nextElement();
				String value = ini.getValue(key);
				System.out.println("key=" + key);
				System.out.println("value=" + value);
			}
		}

		Map<String, Properties> sections = ini.getSections();
		for (Map.Entry<String, Properties> entry : sections.entrySet()) {
			String section = entry.getKey();
			Properties pro = entry.getValue();
			System.out.println("sectionName=" + section);
			for (Enumeration<Object> keys = pro.keys(); keys.hasMoreElements();) {
				String key = (String) keys.nextElement();
				String value = ini.getValue(section, key);
				System.out.println("key=" + section + "." + key);
				System.out.println("value=" + value);
			}
			System.out.println("sectionName=" + section + "����");

		}

	}

}
