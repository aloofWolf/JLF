package org.jlf.plugin.template.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.core.JLFCore;
import org.jlf.plugin.template.client.JLFTemplateClient;

/**
 * 
 * @ClassName: JLFTemplateTest
 * @Description:JLFTemplateTest
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFTemplateTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		JLFTemplateTest server = new JLFTemplateTest();
		server.starts();
		server.getStringFromClassPathMapTest();
		server.getStringFromClassPathObjTest();
	}

	/**
	 * 
	 * @Title: getStringFromClassPathMapTest
	 * @Description:用map生成模板字符串测试
	 */
	public void getStringFromClassPathMapTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SrvDate", "aaa");
		map.put("SrvTime", "bbb");
		map.put("SrvOpName", "ccc");
		map.put("MsgID", "ddd");
		map.put("CorrID", "eee");
		map.put("Branch", "fff");
		map.put("Company", "ggg");
		Map<String, Object> d1 = new Detail("123", "234", "345", "456", "567").toMap();
		Map<String, Object> d2 = new Detail("1234", "2345", "3456", "4567", "5678").toMap();
		Map<String, Object> d3 = new Detail("12345", "23456", "34567", "45678", "56789").toMap();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		map.put("details", list);
		String result = JLFTemplateClient.get().getStringFromClassPath("veloMap.vm", map, "map");
		System.out.println(result);
	}

	/**
	 * 
	 * @Title: getStringFromClassPathObjTest
	 * @Description:用对象生成模板字符串测试
	 */
	public void getStringFromClassPathObjTest() {
		Total total = new Total();
		total.setSrvDate("aaa");
		total.setSrvTime("bbb");
		total.setSrvOpName("ccc");
		total.setMsgID("ddd");
		total.setCorrID("eee");
		total.setBranch("fff");
		total.setCompany("hhh");

		Detail d1 = new Detail("123", "234", "345", "456", "567");
		Detail d2 = new Detail("1234", "2345", "3456", "4567", "5678");
		Detail d3 = new Detail("12345", "23456", "34567", "45678", "56789");
		List<Detail> list = new ArrayList<Detail>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		total.setDetails(list);
		String result = JLFTemplateClient.get().getStringFromClassPath("veloObj.vm", total, "obj");
		System.out.println(result);
	}

}
