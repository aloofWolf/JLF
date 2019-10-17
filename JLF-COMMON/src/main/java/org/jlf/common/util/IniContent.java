package org.jlf.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @ClassName: IniContent
 * @Description: ��ini�ļ��Ľ�������
 * @author Lone Wolf
 * @date 2019��10��17��
 */
public class IniContent {

	private Properties pros = new Properties(); // �洢��ǩ֮�������
	private Map<String, IniContent> sections = new HashMap<String, IniContent>();// �洢Ƕ�ױ�ǩ������
	private Map<String, List<IniContent>> sectionArrs = new HashMap<String, List<IniContent>>();// �洢Ƕ�ױ�ǩ���������

	/**
	 * 
	 * @Title: putProp
	 * @Description: ���Properties����ֵ
	 * @param key
	 * @param value
	 */
	protected void putProp(String key, String value) {
		pros.put(key, value);
	}

	/**
	 * 
	 * @Title: putSection
	 * @Description: ���Ƕ�ױ�ǩ����ֵ
	 * @param sectionName
	 * @param content
	 */
	protected void putSection(String sectionName, IniContent content) {
		sections.put(sectionName, content);
	}

	/**
	 * 
	 * @Title: getSection
	 * @Description:�Ƴ�Ƕ�ױ�ǩ����
	 * @param sectionName
	 * @return
	 */
	protected void removeSection(String sectionName) {
		sections.remove(sectionName);
	}

	/**
	 * 
	 * @Title: putSectionArr
	 * @Description: ���Ƕ�ױ�ǩ��������ֵ
	 * @param sectionArrName
	 * @param content
	 */
	protected void putSectionArr(String sectionArrName, IniContent content) {
		List<IniContent> contents = sectionArrs.get(sectionArrName);
		if (contents == null) {
			contents = new ArrayList<IniContent>();
			sectionArrs.put(sectionArrName, contents);
		}
		contents.add(content);
	}

	/**
	 * 
	 * @Title: getSection
	 * @Description:��ȡǶ�ױ�ǩ����
	 * @param sectionName
	 * @return
	 */
	public IniContent getSection(String sectionName) {
		return sections.get(sectionName);
	}

	/**
	 * 
	 * @Title: getSectionArr
	 * @Description:��ȡǶ�ױ�����ǩ����
	 * @param sectionName
	 * @return
	 */
	public List<IniContent> getSectionArr(String sectionArrName) {
		return sectionArrs.get(sectionArrName);
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
	 * @Description:��ȡǶ�ױ�ǩ�ڵ�ĳ������ֵ
	 * @param section
	 * @param name
	 * @return
	 */
	public String getValue(String sectionName, String name) {
		IniContent content = (IniContent) sections.get(sectionName);

		if (content == null) {
			return null;
		}
		String value = content.getPros().getProperty(name);
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
	 * @Description:��ȡȫ��Ƕ�ױ�ǩ����
	 * @return
	 */
	public Map<String, IniContent> getSections() {
		return sections;
	}

	/**
	 * 
	 * @Title: getSectionArrs
	 * @Description:��ȡȫ��Ƕ�ױ�ǩ��������
	 * @return
	 */
	public Map<String, List<IniContent>> getSectionArrs() {
		return sectionArrs;
	}

}
