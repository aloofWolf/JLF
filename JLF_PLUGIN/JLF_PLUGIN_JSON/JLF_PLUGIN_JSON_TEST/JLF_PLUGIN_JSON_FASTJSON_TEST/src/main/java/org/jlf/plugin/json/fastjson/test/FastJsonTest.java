package org.jlf.plugin.json.fastjson.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.plugin.json.server.api.JLFJsonArray;

/**
 * 
 * @ClassName: FastJsonTest
 * @Description:fastJson≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ6‘¬6»’
 */
public class FastJsonTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		FastJsonTest server = new FastJsonTest();
		server.starts();
		JLFJson json = JLFJsonClient.get().newJson();
		json.put("aa", "qwe");
		json.put("bb", 1);
		json.put("cc", 1l);
		LogUtil.get().debug(json.toStr());
		Map<String, Object> map = json.toMap();
		Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			LogUtil.get().debug("map key={}", entry.getKey());
			LogUtil.get().debug("map value={}", entry.getValue());
		}
		// json.remove("aa");
		Bean bean = json.toBean(Bean.class);
		LogUtil.get().debug("bean={}", bean.toString());
		LogUtil.get().debug("aa={}", json.getStr("aa"));
		LogUtil.get().debug("bb={}", json.getInt("bb"));
		LogUtil.get().debug("cc={}", json.getLong("cc"));
		LogUtil.get().debug("jsonsize={}", json.size());
		JLFJsonArray array = JLFJsonClient.get().newJsonArray();
		JLFJson json2 = JLFJsonClient.get().newJson();
		json2.put("aa", "qwert");
		json2.put("bb", 13);
		json2.put("cc", 14l);

		JLFJson json3 = JLFJsonClient.get().newJson();
		json3.put("aa", "qwertrty");
		json3.put("bb", 135);
		json3.put("cc", 146l);

		array.add(json2);
		array.add(json3);

		json.put("array", array);
		LogUtil.get().debug(json.toStr());
	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFJsonClient(new FastJsonServer()));
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

class Bean {

	private String aa;
	private Long bb;
	private Integer cc;

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public Long getBb() {
		return bb;
	}

	public void setBb(Long bb) {
		this.bb = bb;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Bean [aa=" + aa + ", bb=" + bb + ", cc=" + cc + "]";
	}

}
