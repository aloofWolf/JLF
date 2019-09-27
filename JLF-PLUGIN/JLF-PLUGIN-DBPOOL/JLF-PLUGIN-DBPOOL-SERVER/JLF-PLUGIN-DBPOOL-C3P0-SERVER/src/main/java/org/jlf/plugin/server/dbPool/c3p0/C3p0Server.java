package org.jlf.plugin.server.dbPool.c3p0;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.server.core.dbPool.c3p0.C3p0Core;
import org.jlf.plugin.server.core.dbPool.c3p0.C3p0Pool;
import org.jlf.plugin.server.core.dbPool.c3p0.config.C3p0MainConfig;

/**
 * 
 * @ClassName: C3p0Server
 * @Description:DbPool�����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class C3p0Server extends JLFPluginServer<JLFDbPool> {

	@Override
	public JLFDbPool getServerApi() {
		return new C3p0Core();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;

	}

	@Override
	public void start() {
		Properties prop = super.getConfig();
		start(prop);
	}

	@Override
	public void reStart() {
		Properties prop = super.getConfig(true);
		start(prop);
	}

	/**
	 * 
	 * @Title: start
	 * @Description:��������
	 * @param prop
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start(Properties prop) {
		JLFCheck ckeck = JLFCheckClient.get();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		C3p0MainConfig config = ckeck.check(map, C3p0MainConfig.class);
		C3p0Pool.initMainDataSource(config);
	}

}
