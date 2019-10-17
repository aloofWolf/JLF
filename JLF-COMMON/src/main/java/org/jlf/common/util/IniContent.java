package org.jlf.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @ClassName: IniContent
 * @Description: 。ini文件的解析内容
 * @author Lone Wolf
 * @date 2019年10月17日
 */
public class IniContent {

	private Properties pros = new Properties(); // 存储标签之外的属性
	private Map<String, IniContent> sections = new HashMap<String, IniContent>();// 存储嵌套标签的属性
	private Map<String, List<IniContent>> sectionArrs = new HashMap<String, List<IniContent>>();// 存储嵌套标签数组的属性

	/**
	 * 
	 * @Title: putProp
	 * @Description: 添加Properties属性值
	 * @param key
	 * @param value
	 */
	protected void putProp(String key, String value) {
		pros.put(key, value);
	}

	/**
	 * 
	 * @Title: putSection
	 * @Description: 添加嵌套标签属性值
	 * @param sectionName
	 * @param content
	 */
	protected void putSection(String sectionName, IniContent content) {
		sections.put(sectionName, content);
	}

	/**
	 * 
	 * @Title: getSection
	 * @Description:移除嵌套标签属性
	 * @param sectionName
	 * @return
	 */
	protected void removeSection(String sectionName) {
		sections.remove(sectionName);
	}

	/**
	 * 
	 * @Title: putSectionArr
	 * @Description: 添加嵌套标签数组属性值
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
	 * @Description:获取嵌套标签属性
	 * @param sectionName
	 * @return
	 */
	public IniContent getSection(String sectionName) {
		return sections.get(sectionName);
	}

	/**
	 * 
	 * @Title: getSectionArr
	 * @Description:获取嵌套标数组签属性
	 * @param sectionName
	 * @return
	 */
	public List<IniContent> getSectionArr(String sectionArrName) {
		return sectionArrs.get(sectionArrName);
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
	 * @Description:获取嵌套标签内的某个属性值
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
	 * @Description:获取全部嵌套标签属性
	 * @return
	 */
	public Map<String, IniContent> getSections() {
		return sections;
	}

	/**
	 * 
	 * @Title: getSectionArrs
	 * @Description:获取全部嵌套标签数组属性
	 * @return
	 */
	public Map<String, List<IniContent>> getSectionArrs() {
		return sectionArrs;
	}

}
