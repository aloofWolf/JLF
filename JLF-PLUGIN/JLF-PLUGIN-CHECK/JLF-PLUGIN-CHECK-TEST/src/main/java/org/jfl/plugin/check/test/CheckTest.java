package org.jfl.plugin.check.test;

import java.lang.reflect.Method;
import java.util.List;

import org.jfl.plugin.check.test.bean.MethodTest;
import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

/**
 * 
 * @ClassName: CheckTest
 * @Description:Check����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class CheckTest {

	/**
	 * 
	 * @Title: main
	 * @Description:checkWolf����
	 * @param args
	 */
	public static void main(String[] args) {
		LogUtil.get().debug("aa");
		JLFCore.starts();
		/*JLFJson json = JLFJsonClient.get().newJson();
		json.put("f", 99.99);
		JLFJsonArray array = JLFJsonClient.get().newJsonArray();

		JLFJson b1 = JLFJsonClient.get().newJson();
		b1.put("str", "qq");
		b1.put("date", new Date());
		b1.put("b", 1);

		JLFJson b2 = JLFJsonClient.get().newJson();
		b2.put("str", "ww");
		b2.put("date", new Date());
		b2.put("b", 2);

		JLFJson b3 = JLFJsonClient.get().newJson();
		b3.put("str", "ee");
		b3.put("date", new Date());
		b3.put("b", 3);

		array.add(b1);
		array.add(b2);
		array.add(b3);
		json.put("list", array);

		json.put("s", "rr");
		json.put("intt", 99);

		JLFJson map = JLFJsonClient.get().newJson();
		map.put("aa", "ss");
		map.put("dd", "gg");
		map.put("zz", "xx");
		json.put("map", map);

		JLFJson b4 = JLFJsonClient.get().newJson();
		b4.put("s", 11);
		b4.put("bigd", 11.23);
		b4.put("intt", 101);

		json.put("r2", b4);
		json.put("l", 0);
		json.put("d", 11.2);
		System.out.println(json.toStr());
		ChildBean bean = JLFCheckClient.get().check(json.toStr(), ChildBean.class);
		System.out.println(bean.toString());*/
		
		JLFJson json = JLFJsonClient.get().newJson();
		json.put("str1", "qq");
		json.put("l2", 123);
		JLFJson b1 = JLFJsonClient.get().newJson();
		b1.put("l", -1);
		b1.put("d", 0.1);
		
		JLFJson b2 = JLFJsonClient.get().newJson();
		b2.put("l", -2);
		b2.put("d", 0.2);
		
		JLFJson b3 = JLFJsonClient.get().newJson();
		b3.put("l", -3);
		b3.put("d", 0.3);
		
		JLFJsonArray array = JLFJsonClient.get().newJsonArray();
		array.add(b1);
		array.add(b2);
		array.add(b3);
		json.put("bean", array);
		Method method = null;
		try {
			method = MethodTest.class.getDeclaredMethod("test", String.class,Long.class,List.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] values = JLFCheckClient.get().check(json.toStr(), method);
		for(Object value : values){
			LogUtil.get().debug(value.toString());
		}
	}

}