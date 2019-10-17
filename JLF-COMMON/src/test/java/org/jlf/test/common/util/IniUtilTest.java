package org.jlf.test.common.util;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jlf.common.util.IniContent;
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
	 */
	@Test
	public void iniRead() {
		IniContent content = IniUtil.parse("I:/workspace/SKLF/cfm-main/cfm/src/main/resources/cfm_config.ini");
		printContent(content);

	}
	
	private void printContent(IniContent content){
		Properties pros = content.getPros();
		if (pros != null) {
			for (Enumeration<Object> keys = pros.keys(); keys.hasMoreElements();) {
				String key = (String) keys.nextElement();
				String value = content.getValue(key);
				System.out.println("key=" + key);
				System.out.println("value=" + value);
			}
		}
		
		Map<String, IniContent> sections = content.getSections();
		if(sections != null){
			for (Map.Entry<String, IniContent> entry : sections.entrySet()) {
				String sectionName = entry.getKey();
				IniContent currContent = content.getSection(sectionName);
				System.out.println("sectionName=" + sectionName + "��ʼ");
				printContent(currContent);
				System.out.println("sectionName=" + sectionName + "����");

			}
		}
		
		Map<String, List<IniContent>> sectionArrs = content.getSectionArrs();
		if(sections != null){
			for (Map.Entry<String, List<IniContent>> entry : sectionArrs.entrySet()) {
				String sectionName = entry.getKey();
				List<IniContent> contents = content.getSectionArr(sectionName);
				System.out.println("sectionName=" + sectionName + "��ʼ");
				for(IniContent c : contents){
					printContent(c);
				}
				
				System.out.println("sectionName=" + sectionName + "����");

			}
		}
	}

}
