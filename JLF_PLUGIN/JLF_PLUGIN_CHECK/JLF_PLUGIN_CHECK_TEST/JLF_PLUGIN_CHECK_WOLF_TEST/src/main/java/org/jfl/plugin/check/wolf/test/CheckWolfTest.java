package org.jfl.plugin.check.wolf.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfl.plugin.check.wolf.test.bean.ChildBean;
import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

/**
 * 
 * @ClassName: CheckWolfTest
 * @Description:CheckWolf≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ6‘¬4»’
 */
public class CheckWolfTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:checkWolf≤‚ ‘
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CheckWolfTest server = new CheckWolfTest();
		server.starts();
		JLFJson json = JLFJsonClient.get().newJson();
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
		System.out.println(bean.toString());
	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFJsonClient(new FastJsonServer()));
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}

}